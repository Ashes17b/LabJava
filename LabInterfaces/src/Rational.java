import java.text.ParseException;
import java.util.*;

public class Rational implements Comparable<Rational>, Iterator<Integer> {
    private static Rational zero = new Rational(0, 1);

    private int numerator;   // the numerator
    private int denominator;   // the denominator

    public Rational() { numerator = 0; denominator = 1; }
    // create and initialize a new Rational object
    public Rational(int num, int denom) {
        if (denom == 0) {
            throw new ArithmeticException("Denominator is zero");
        }

        // reduce fraction
        int g = gcd(num, denom);
        numerator = num / g;
        denominator = denom / g;

        // needed only for negative numbers
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    // return the numerator and denominator of (this)
    public int getNumerator()   { return numerator; }
    public int getDenominator() { return denominator; }

    // is this Rational object equal to y?
    public boolean equals(Object y) {
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Rational b = (Rational) y;
        return compareTo(b) == 0;
    }

    // return gcd(|m|, |n|)
    private static int gcd(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }

    // return lcm(|m|, |n|)
    private static int lcm(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        return m * (n / gcd(m, n));    // parentheses important to avoid overflow
    }

    // return a * b, staving off overflow as much as possible by cross-cancellation
    public Rational multiply(Rational b) {
        Rational a = this;

        // reduce p1/q2 and p2/q1, then multiply, where a = p1/q1 and b = p2/q2
        Rational c = new Rational(a.numerator, b.denominator);
        Rational d = new Rational(b.numerator, a.denominator);
        return new Rational(c.numerator * d.numerator, c.denominator * d.denominator);
    }

    // return a + b, staving off overflow
    public Rational plus(Rational b) {
        Rational a = this;

        // special cases
        if (a.compareTo(zero) == 0) return b;
        if (b.compareTo(zero) == 0) return a;

        // Find gcd of numerators and denominators
        int f = gcd(a.numerator, b.numerator);
        int g = gcd(a.denominator, b.denominator);

        // add cross-product terms for numerator
        Rational s = new Rational((a.numerator / f) *
                (b.denominator / g) + (b.numerator / f) * (a.denominator / g),
                lcm(a.denominator, b.denominator));

        // multiply back in
        s.numerator *= f;
        return s;
    }

    // return -a
    public Rational negate() {
        return new Rational(-numerator, denominator);
    }

    // return a - b
    public Rational minus(Rational b) {
        Rational a = this;
        return a.plus(b.negate());
    }

    public Rational reciprocal() { return new Rational(denominator, numerator);  }

    // return a / b
    public Rational divides(Rational b) {
        Rational a = this;
        return a.multiply(b.reciprocal());
    }

    /** Construct a rational with string numerator and denominator */
    public Rational(String str) throws ParseException {
        int num = Integer.parseInt(str.substring(str.indexOf("numerator:") + 10, str.indexOf(",")));
        int denom = Integer.parseInt(str.substring(str.indexOf("denominator:") + 12, str.length()));
        if (denom == 0) {
            throw new ArithmeticException("Denominator is zero");
        }

        // reduce fraction
        int g = gcd(num, denom);
        numerator = num / g;
        denominator = denom / g;

        // needed only for negative numbers
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    //Comparable<Rational>
    @Override
    public int compareTo(Rational b) {
        Rational a = this;
        int lhs = a.numerator * b.denominator;
        int rhs = a.denominator * b.numerator;
        if (lhs < rhs)
            return -1;
        if (lhs > rhs)
            return 1;
        return 0;
    }

    private static String[] sorting = {"numerator", "denominator"};

    //Iterator<Integer>
    private int iteration = 0;
    @Override
    public boolean hasNext() { return iteration < sorting.length; }

    @Override
    public Integer next() {
        iteration++;
        if(iteration <= sorting.length) {
            switch (iteration) {
                case 1:
                    return this.numerator;
                case 2:
                    return this.denominator;
            }
        }
        iteration = 0;
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }
}