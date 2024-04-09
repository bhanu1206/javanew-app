package app;

public class Factorial {
    /**
     * Compute the factorial of a non-negative integer n.
     *
     * @param n An integer
     * @return The factorial of n
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
