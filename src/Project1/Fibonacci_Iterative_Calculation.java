package Project1;


import java.math.BigInteger;

/**
 * Created by dashu on 2017/9/13.
 */
public class Fibonacci_Iterative_Calculation {
    BigInteger f[];
    public static void main(String[] args) {


        for(BigInteger i = new BigInteger(String.valueOf(43)); ; i = i.add(BigInteger.valueOf(1))){


          Fibonacci_Iterative_Calculation fibonacci_iterative = new Fibonacci_Iterative_Calculation();
            long start = System.currentTimeMillis();
            BigInteger result = fibonacci_iterative.fib(i);
            System.out.println("Fibonacci[" + i + "]=" + result);
            long end = System.currentTimeMillis();
            long costtime = end - start;
            System.out.println("CostTime is " + costtime + " ms");
            if (costtime / 1000 >= 60) {
                System.out.println("CostTime is " + costtime + " ms");
                System.out.println("The number is " + i);
                break;
            }
        }
    }

    public BigInteger fib(BigInteger n) {

        f = new BigInteger[n.intValue() + 1];
        f[0] = BigInteger.ZERO;
        BigInteger result = f[0];
        if (n.compareTo(BigInteger.ZERO) == 1) {
            f[1] = BigInteger.ONE;
            result = Loop(1000, n);//Because the calculation is based on previous two elements
            // so if we need 10000 times of operation, we divide the in to several blocks 100*10 in order to avoid overflow
        }
        return result;
    }

    public BigInteger Loop(int division, BigInteger n) {

        for (int j = 0; j <= division - 1; j++) {
            if (j == division - 1) {
                BigInteger i;
                for (i = new BigInteger(String.valueOf(2)); i.compareTo(n.subtract(n.divide(BigInteger.valueOf(division)).
                        multiply(BigInteger.valueOf(j)))) != 1; i = i.add(BigInteger.ONE)) {
                    f[i.intValue()] = f[i.intValue() - 2].add(f[i.intValue() - 1]);
                }
                return f[i.intValue() - 1];
            } else {
                BigInteger i;
                for (i = new BigInteger(String.valueOf(2)); i.compareTo(n.divide(BigInteger.valueOf(division)).add(BigInteger.ONE)) != 1;
                     i = i.add(BigInteger.ONE)) {
                    f[i.intValue()] = f[i.intValue() - 2].add(f[i.intValue() - 1]);
                }
                f[0] = f[i.intValue() - 2];
                f[1] = f[i.intValue() - 1];
            }
        }
        return null;
    }
}
