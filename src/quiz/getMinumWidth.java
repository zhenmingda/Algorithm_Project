package quiz;

import java.util.Arrays;

/**
 * Created by Mingda Zhen on 10/3/2017.
 */
public class getMinumWidth {
    public static void main(String[] args) {
        int n = 11;//the number of the book
        int W[] = {1,1,1,2,2,2,3,3,3,4,5};//the width of each book
        int k = 3;

        Arrays.sort(W);//sort array
        //imagine it as a k layer shelves,each element means the width of books at that layer
        int newArrangement[] = new int[k];
        for (int i = 0; i < k; i++) {
            newArrangement[i] = W[n - k + i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            newArrangement[0] = newArrangement[0] + W[i];
            Arrays.sort(newArrangement);
        }
        System.out.println("The minium of width of the widest shelf is " + newArrangement[k - 1]);
    }

}
