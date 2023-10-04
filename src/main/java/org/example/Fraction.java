package org.example;

public class Fraction {

    private int numerator; // zaehler
    private int denominator; // nenner

    public Fraction(int numerator, int denominator) throws DivisionByZeroException {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) throws DivisionByZeroException {
        if (denominator == 0) {
            throw new DivisionByZeroException();
        }

        this.denominator = denominator;
    }

    public Fraction shorten() {
        try {
            int tmp = Math.min(getDenominator(), getNumerator());

            for (int i = tmp; i > 1; --i) {
                if (getDenominator() % i == 0 && getNumerator() % i == 0) {
                    return new Fraction(getNumerator() / i, getDenominator() / i);
                }
            }

            return new Fraction(this.getNumerator(), this.getDenominator());
        } catch (DivisionByZeroException e) {
            throw new RuntimeException();
        }
    }

    public Fraction add(Fraction other) {
        int newNumerator = other.getNumerator() * this.getDenominator() + this.getNumerator() * other.getDenominator();
        int newDenominator = this.getDenominator() * other.getDenominator();

        try {
            return new Fraction(newNumerator, newDenominator).shorten();
        } catch (DivisionByZeroException e) {
            throw new RuntimeException(e);
        }
    }

    public Fraction sub(Fraction other) {
        int newNumerator = this.getNumerator() * other.getDenominator() - other.getNumerator() * this.getDenominator();
        int newDenominator = this.getDenominator() * other.getDenominator();

        try {
            return new Fraction(newNumerator, newDenominator).shorten();
        } catch (DivisionByZeroException e) {
            throw new RuntimeException(e);
        }
    }

    public Fraction mult(Fraction other) {
        int newNumerator = this.getNumerator() * other.getNumerator();
        int newDenominator = this.getDenominator() * other.getDenominator();

        try {
            return new Fraction(newNumerator, newDenominator).shorten();
        } catch (DivisionByZeroException e) {
            throw new RuntimeException(e);
        }
    }

    public Fraction div(Fraction other) {
        int newNumerator = this.getNumerator() * other.getDenominator();
        int newDenominator = this.getDenominator() * other.getNumerator();

        try {
            return new Fraction(newNumerator, newDenominator).shorten();
        } catch (DivisionByZeroException e) {
            throw new RuntimeException(e);
        }
    }

    public Fraction reziprocal() {
        try {
            return new Fraction(getDenominator(), getNumerator()).shorten();
        } catch (DivisionByZeroException e) {
            throw new RuntimeException(e);
        }
    }
}