/**
 *
 * Multiply, divide and subtract using only addition operator
 *
 **/

public class ArithmeticOperators {

    static int abs(int num) {
        return num < 0 ? negate(num) : num;
    }

    static int negate (int num) {
        int negation = 0;
        int diff = num > 0 ? -1 : 1;
        int n = num;
        while (n != 0) {
            n += diff;
            negation += diff;
        }
        return negation;
    }

    static int multiply (int a, int b) {
        
        // minimize addition operations
        if (abs(a) < abs(b))
            return multiply(b, a);
        
        int result = 0;
        for (int i = 0; i < abs(b); i++)
            result += a;

        if (b < 0)
            result = negate(result);

        return result;
    }

    static int subtract (int a, int b) {
        return a  + negate(b);
    }

    static int divide(int a, int b) throws IllegalArgumentException {
        int x = abs(a);
        int y = abs(b);
        int q = 0;
        int r = 0;
        boolean hasDifferentSign = (a < 0 && b > 0) || (a > 0 && b < 0);

        if (b == 0)
            throw new IllegalArgumentException("Divide by zero");

        while (r < x) {
            r += y;
            q += 1;
        }

        if (r > x && !hasDifferentSign)
            q--;

        if (hasDifferentSign)
            q = negate(q);

        return q;
    }

    public static void main(String []args) {

        // Subtraction
        System.out.println(subtract(1, 1)  == 0);
        System.out.println(subtract(2, -2) == 4);
        System.out.println(subtract(5, 10) == -5);

        // multiply
        System.out.println(multiply(2, 5)   == 10);
        System.out.println(multiply(2, -5)  == -10);
        System.out.println(multiply(-2, -5) == 10);
        System.out.println(multiply(2, 0)   == 0);

        //division
        System.out.println(divide(4, 2)   == 2);
        System.out.println(divide(7, 2)   == 3);
        System.out.println(divide(0, 10)  == 0);
        System.out.println(divide(-5, 2)  == -3);
        System.out.println(divide(-7, -2) == 3);
    }
}