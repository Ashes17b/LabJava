import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
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
    public void testExceptionDenominator() throws ParseException {
        Rational test1 = new Rational(1, 1);
        String str = "numerator:4, denominator:0";
        Rational test2 = new Rational(str);
    }

    @Test
    public void setSortBy() {
        Rational[] arr = new Rational[3];
        arr[0] = new Rational(3, 4);
        arr[1] = new Rational(2, 6);
        arr[2] = new Rational(8, 3);

        try {
            sortAndPrint(arr);

            Rational.setSortBy("denominator");
            sortAndPrint(arr);
        } catch (RationalException e) {
            e.printStackTrace();
        }
    }

    private static void sortAndPrint(Rational[] arr) {
        System.out.println("Sorted by: " + Rational.getSortBy());

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i].toString());

        System.out.println("\n");
    }
}
