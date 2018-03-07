package Project1;

import java.math.BigInteger;

/**
 * Created by Mingda Zhen on 2017/9/13.
 */
public class Fibonacci_Recursive_Caculation {
    public static void main(String[] args) {
        for (int i = 27; ; i++) {
            long start = System.currentTimeMillis();
            BigInteger result = fib(BigInteger.valueOf(i));//call fib function
            System.out.println("Fibonacci[" + i + "]=" + result);
            long end = System.currentTimeMillis();
            long cost_time = end - start;//calculate duration time(unit ms)
            System.out.println("CostTime is " + cost_time + " ms");
            if (cost_time / 1000 >= 60) {
                System.out.println("The number is " + i);
                break;
            }
        }
    }

    private static BigInteger fib(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) != 1)
            return n;
        else return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.valueOf(2))));//recursion
    }
}
