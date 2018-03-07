package Project_2;

import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Math.min;
import static java.lang.Math.toIntExact;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyArrayForFloyd {
    public static void main(String[] args) {

        System.out.println("Input the number of vertices for Complete graph (Floyd) Data Structure one dimmensional array");
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        AdjacencyArrayForCompleteGraph graph = new AdjacencyArrayForCompleteGraph();
        long startForComplete = System.currentTimeMillis();
        int[] adjacencyArray = graph.generateGraph(vertices);
        floyd(vertices, adjacencyArray);
        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Complete Graph is " + cost_timeForComplete + " s");


        System.out.println("Input the number of vertices for Sparse graph (Floyd) Data Structure one dimmensional array");
        int verticesForSparse = vertices;
        s.close();
        AdjacencyArrayForSparseGraph sparseGraph = new AdjacencyArrayForSparseGraph();
        long startForSparse = System.currentTimeMillis();
        int[] adjacencyArrayForSparse = sparseGraph.generateGraph(verticesForSparse);
        floyd(verticesForSparse, adjacencyArrayForSparse);
        long endForSparse = System.currentTimeMillis();
        long cost_timeForSparse = (endForSparse - startForSparse) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Sparse Graph is " + cost_timeForSparse + " s");



    }



    static void floyd(int vertices, int[] adjacencyArray) {
        int[][] P = new int[vertices][vertices];
        int[] length = adjacencyArray;

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                P[i][j] = 0;

            }
        }
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < i; j++) {
                    if (compareIndex(i, j) < adjacencyArray.length && compareIndex(i, k) < adjacencyArray.length && compareIndex(k, j) < adjacencyArray.length) {

                        if ((length[compareIndex(i, k)] + length[compareIndex(k, j)]) < 0) {//check overflow
                            continue;
                        }
                        if (length[compareIndex(i, j)] > length[compareIndex(i, k)] + length[compareIndex(k, j)]) {
                            P[i][j] = k;
                            P[j][i] = P[i][j];
                            length[compareIndex(i, j)] = length[compareIndex(i, k)] + length[compareIndex(k, j)];
                        }
                    }
                }
            }
        }


       for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) continue;

                System.out.println("From V" + (i + 1) + " to V" + (j + 1) + " is ");
                System.out.print("V" + (i + 1) + "->");
                path(P, i, j);
                System.out.println("V" + (j + 1));
                if (i > j) {
                    System.out.println("The distance is " + length[i * (i - 1) / 2 + j]);
                } else {
                    System.out.println("The distance is " + length[j * (j - 1) / 2 + i]);

                }
            }
        }
    }

    private static int compareIndex(int i, int k) {

        int a = max(i, k);
        int b = min(i, k);
        int result = (a * (a - 1) / 2) + b;
        return result;
    }



    static void path(int[][] P, int q, int r) {
        if (P[q][r] != 0) {
            path(P, q, P[q][r]);
            System.out.print("V" + (P[q][r] + 1) + "->");
            path(P, P[q][r], r);

        }
    }
}
