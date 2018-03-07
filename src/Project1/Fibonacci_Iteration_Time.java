package Project1;

/**
 * Created by dashu on 2017/9/17.
 */
public class Fibonacci_Iteration_Time {
    public static void main(String[] args) {
        for (int i = 10000; ; i=i+1000) {
            long start = System.currentTimeMillis();
            String result = fib(i);//call fib function
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

    private static String fib(int n) {
        int i;
        String f[] = new String[n + 1];
        f[0] = "0";
        if (n > 0) {
            f[1] = "1";
            for (i = 2; i <= n; i++) {
                f[i] = add(f[i - 1], f[i - 2]);
            }
        }
        return f[n];

    }

    private static String add(String fibMinus1, String fibMinus2) {

        String fM3 = "";//the result of addition from lower part and finally it becomes the result of calculation
        String fM4 = "";// the extra digits of larger number for example 1234567+123, fM4=1234
        String fM5 = "";//the result of the carry from the lower part plus fM4
        int difference = fibMinus1.length() - fibMinus2.length();

        int carry = 0;
        for (int i = fibMinus2.length() - 1; i >= 0; i--) {
            //add two numbers and the number of digits is based on smaller number
            //for example 123456+123, calculate 456+123 as a part, the remaining part will be concated as a string.
            String Intermediate = String.valueOf(carry + Integer.parseInt(String.valueOf(fibMinus2.charAt(i)))
                    + Integer.parseInt(String.valueOf(fibMinus1.charAt(i + difference))));
            if (Intermediate.length() > 1) {
                carry = Integer.parseInt(Intermediate) / 10;
            } else {
                carry = 0;
            }
            fM3 = String.valueOf(Integer.parseInt(Intermediate) % 10) + fM3;

        }
        if (difference == 0 && carry > 0) {
            fM3 = String.valueOf(carry) + fM3;
            //when the number of digits of two numbers are same
            //use this funtion to concat string
        } else {//when the number of digits of two numbers are not same,use this method to concat the extra string
            //and calculated string and concerning carry
            fM4 = fibMinus1.substring(0, difference);
            for (int q = fM4.length() - 1; q >= 0; q--) {//q is the index
                //addition is based on corresponding position of the number
                String Intermediate = String.valueOf(carry + Integer.parseInt(String.valueOf(fM4.charAt(q))));
                if (Intermediate.length() > 1) {
                    carry = Integer.parseInt(Intermediate) / 10;//the carry is for next round add calculation
                } else {//if the carry is zero, set it to zero
                    carry = 0;
                }
                fM5 = String.valueOf(Integer.parseInt(Intermediate) % 10) + fM5;
            }
        }
        fM3 = fM5 + fM3;

        return fM3;
    }

}
