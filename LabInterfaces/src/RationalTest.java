import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class RationalTest {
    Rational tester;
    Rational operationTest = new Rational(8, 6);
    @Before
    public void setUp() throws Exception {
        tester = new Rational();
    }

    @Test
    public void getNumerator() throws Exception {
        assertEquals("Result", 0, tester.getNumerator());
    }

    @Test
    public void getDenominator() throws Exception {
        assertEquals("Result", 1, tester.getDenominator());
    }

    @Test
    public void multiply() throws Exception {
        assertEquals("Result", new Rational(0, 1), tester.multiply(operationTest));
    }

    @Test
    public void plus() throws Exception {
        assertEquals("Result", new Rational(4, 3), tester.plus(operationTest));
    }

    @Test
    public void minus() throws Exception {
        assertEquals("Result", new Rational(-4, 3), tester.minus(operationTest));
    }

    @Test
    public void divides() throws Exception {
        assertEquals("Result", new Rational(0, 1), tester.divides(operationTest));
    }

    @Test
    public void compareTo() throws Exception {
        assertEquals("Result", -1, tester.compareTo(operationTest));
    }

    Iterator it = new Rational(3, 4);
    @Test
    public void hasNext() throws Exception {
        assertEquals("Result", true, it.hasNext());
    }

    @Test
    public void next() throws Exception {
        assertEquals("Result", 3, it.next());
        assertEquals("Result", 4, it.next());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testExceptionRemove() {
        it.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testExceptionNext() {
        it.next();
        it.next();
        it.next();
    }

    @Test(expected = ArithmeticException.class)
    public void testExceptionDenominator() {
        Rational r = new Rational(1, 0);
    }
}
