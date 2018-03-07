package Project_2;

import java.util.Scanner;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyMatrixForFloyd {
    public static void main(String[] args) {
        System.out.println("Input the number of vertices for Test case 1 graph (Floyd)");
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        AdjacencyMatrixForCompleteGraph graph = new AdjacencyMatrixForCompleteGraph();
        long startForComplete = System.currentTimeMillis();
        int[][] adjacencyMatrix = graph.generateGraph(vertices);
        floyd(vertices, adjacencyMatrix);
        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete) / (1000); //calculate duration time(unit ms)
        System.out.println("Cost Time For Complete Graph is " + cost_timeForComplete + " s");


        System.out.println("Input the number of vertices for Sparse graph (Floyd)");
        int verticesForSparse = vertices;
        s.close();
        AdjacencyMatrixForSparseGraph sparseGraph = new AdjacencyMatrixForSparseGraph();
        long startForSparse = System.currentTimeMillis();
        int[][] adjacencyMatrixForSparse = sparseGraph.generateGraph(verticesForSparse);
        floyd(verticesForSparse, adjacencyMatrixForSparse);
        long endForSparse = System.currentTimeMillis();
        long cost_timeForSparse = (endForSparse - startForSparse) / (1000);  //calculate duration time(unit ms)
        System.out.println("Cost Time For Sparse Graph is " + cost_timeForSparse + " s");

    }




    private static void path(int[][] P, int q, int r) {
        if (P[q][r] != 0) {
            path(P, q, P[q][r]);
            System.out.print("V" + (P[q][r] + 1) + "->");
            path(P, P[q][r], r);
        }
    }

    private static void floyd(int vertices, int[][] adjacencyMatrix) {
        int[][] dist = adjacencyMatrix;
        int[][] P = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                P[i][j] = 0;

            }
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if ((dist[i][k] + dist[k][j]) < 0) {//check overflow
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        P[i][j] = k;
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {

                if (i == j) {
                    continue;
                }
                System.out.println("From V" + (i + 1) + " to V" + (j + 1) + " is ");
                System.out.print("V" + (i + 1) + "->");
                path(P, i, j);
                System.out.println("V" + (j + 1));
                System.out.println("The distance is " + dist[i][j]);

            }
        }
    }
}
