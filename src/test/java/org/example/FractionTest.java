package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    /**
     * Test the shorten method of the Fraction class.
     * Given: 12 / 4
     * Expected: 3 / 1
     */
    @Test
    void shorten1() throws DivisionByZeroException {
        Fraction f = new Fraction(12, 4);

        Fraction shortened = f.shorten();

        assertEquals(3, shortened.getNumerator());
        assertEquals(1, shortened.getDenominator());
    }

    /**
     * Test the shorten method of the Fraction class.
     * Given: 6 / 8
     * Expected: 3 / 4
     */
    @Test
    void shorten2() throws DivisionByZeroException {
        Fraction f = new Fraction(6, 8);

        Fraction shortened = f.shorten();

        assertEquals(3, shortened.getNumerator());
        assertEquals(4, shortened.getDenominator());
    }

    /**
     * Test the shorten method of the Fraction class.
     * Given: 9 / 7
     * Expected: 9 / 7
     */
    @Test
    void shorten3() throws DivisionByZeroException {
        Fraction f = new Fraction(9, 7);

        Fraction shortened = f.shorten();

        assertEquals(9, shortened.getNumerator());
        assertEquals(7, shortened.getDenominator());
    }

    /**
     * Test the shorten method of the Fraction class.
     * Given: 9 / 7
     * Expected: 9 / 7
     */
    @Test
    void testException() {
        assertThrows(
                DivisionByZeroException.class,
                () -> new Fraction(9, 0)
        );
    }

    @Test
    void add() throws DivisionByZeroException {
        Fraction f = new Fraction(3, 4);
        Fraction other = new Fraction(6, 8);

        Fraction result = f.add(other);

        assertEquals(3, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void sub() throws DivisionByZeroException {
        Fraction f = new Fraction(3, 4);
        Fraction other = new Fraction(2, 8);

        Fraction result = f.sub(other);

        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void mult() throws DivisionByZeroException {
        Fraction f = new Fraction(3, 4);
        Fraction other = new Fraction(2, 8);

        Fraction result = f.mult(other);

        assertEquals(3, result.getNumerator());
        assertEquals(16, result.getDenominator());
    }

    @Test
    void div() throws DivisionByZeroException {
        Fraction f = new Fraction(3, 4);
        Fraction other = new Fraction(2, 8);

        Fraction result = f.div(other);

        assertEquals(3, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    void reziprocal() throws DivisionByZeroException {
        Fraction f = new Fraction(3, 4);

        Fraction result = f.reziprocal();

        assertEquals(4, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }
}