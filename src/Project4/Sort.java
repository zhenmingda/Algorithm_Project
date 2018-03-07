package Project4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sort {
    public static void main(String[] args) {
        long startForComplete = System.currentTimeMillis();
        //int array[] = {62, 31, 84, 96, 19, 47};
        //int array[] = {11, 80, -15, 93, -55, 10, 59, -35, 84, -10, 53, -73, 16, -37, 59, -45, -73, -3, 84, -29, -75, 54, -38, -59, -78,-92, 100, 3, -88, 83, 59, 32, -46, 68, -68, -34, -73, 50, -78, -19};
        //int array[]={ 61,85,70,63,80,60,57,73,31,74,14,2,32,33,13,64,97,59,29,90,66,84,15,29,15,33};

       int array[]={-4,-1,-87,-42,-6,-74,-3,-26,-46,-16,-66,-93,-75,-97,-89,-54,-15,-39,-98,-29};

        System.out.print("Original array: ");
        printArray(array);
        int temp[] = new int[array.length];
        int sortedArray[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
            temp[i] = count;
        }

        System.out.print("Table for the counts: ");
        printArray(temp);


        for (int i = 0; i < temp.length; i++) {

            if (sortedArray[temp[i]] != array[i]) {
                sortedArray[temp[i]] = array[i];
            } else {
                while (true) {
                    temp[i] = temp[i] + 1;
                    if (sortedArray[temp[i]] != array[i]) {
                        sortedArray[temp[i]] = array[i];
                        break;
                    }
                }
            }
        }

        System.out.print("Sorted array: ");
        printArray(sortedArray);

    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
            } else
                System.out.print(array[i] + ", ");
        }
    }
}
