public class Program5 {

    public static void main(String[] args) {
        int[] fibonacciValues = {10, 30, 50};

        for (int n : fibonacciValues) {
            System.out.println("Fibonacci Recursive - N=" + n + ": " + fibonacciRecursive(n) + "ms");
            System.out.println("Fibonacci Iterative - N=" + n + ": " + fibonacciIterative(n) + "ms");
        }
    }

    public static long fibonacciRecursive(int n) {
        long startTime = System.nanoTime();
        System.out.println("Recursive Fibonacci for N=" + n + ": " + fibonacciRecursiveHelper(n));
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static int fibonacciRecursiveHelper(int n) {
        if (n <= 1) return n;
        return fibonacciRecursiveHelper(n - 1) + fibonacciRecursiveHelper(n - 2);
    }

    public static long fibonacciIterative(int n) {
        long startTime = System.nanoTime();
        System.out.println("Iterative Fibonacci for N=" + n + ": " + fibonacciIterativeHelper(n));
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static int fibonacciIterativeHelper(int n) {
        int a = 0, b = 1, sum;
        if (n == 0) return a;
        if (n == 1) return b;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
