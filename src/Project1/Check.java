package Project1;

import java.math.BigInteger;

/**
 * Created by dashu on 2017/9/17.
 */
public class Check {
    public static void main(String[] args) {
        // BigInteger i=new BigInteger("123123");
        String i = "95";
        String j = "28";
        String k = "";
        int difference = j.length() - i.length();
        int carry = 0;
        String L = "";
        String Q = "";
        for (int q = i.length() - 1; q >= 0; q--) {

            String Intermediate = String.valueOf(carry + Integer.parseInt(String.valueOf(i.charAt(q))) + Integer.parseInt(String.valueOf(j.charAt(q + difference))));
            if (Intermediate.length() > 1) {
                carry = Integer.parseInt(Intermediate) / 10;
            } else {
                carry = 0;
            }
            k = String.valueOf(Integer.parseInt(Intermediate) % 10) + k;

        }
        if (difference == 0&&carry>0) {
    k=String.valueOf(carry)+k;
        } else {
            L = j.substring(0, difference);
            for (int q = L.length() - 1; q >= 0; q--) {
                String Intermediate = String.valueOf(carry + Integer.parseInt(String.valueOf(L.charAt(q))));
                if (Intermediate.length() > 1) {
                    carry = Integer.parseInt(Intermediate) / 10;
                } else {
                    carry = 0;
                }
                Q = String.valueOf(Integer.parseInt(Intermediate) % 10) + Q;
            }
        }

        k = Q + k;

        //int k=Integer.parseInt(String.valueOf(i))+Integer.parseInt(String.valueOf(j));
        System.out.print(k);
    }
}
