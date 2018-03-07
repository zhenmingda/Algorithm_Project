package Project_2;

import java.util.Scanner;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyMatrixForDijkstra {
    public static void main(String[] args) {
        System.out.println("Input the number of vertices for Test case 1 graph (Dijkstra) Data Structure two dimmensional array");
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        AdjacencyMatrixForCompleteGraph graph = new AdjacencyMatrixForCompleteGraph();
        long startForComplete = System.currentTimeMillis();
        int[][] adjacencyMatrix = graph.generateGraph(vertices);
        dijkstra(vertices, adjacencyMatrix);
        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Complete Graph is " + cost_timeForComplete + " s");


        System.out.println("Input the number of vertices for Sparse graph (Dijkstra) Data Structure two dimmensional array");
        int verticesForSparse = vertices;
        s.close();
        AdjacencyMatrixForSparseGraph sparseGraph = new AdjacencyMatrixForSparseGraph();
        long startForSparse = System.currentTimeMillis();
        int[][] adjacencyMatrixForSparse = sparseGraph.generateGraph(verticesForSparse);
        dijkstra(verticesForSparse, adjacencyMatrixForSparse);
        long endForSparse = System.currentTimeMillis();
        long cost_timeForSparse = (endForSparse - startForSparse) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Sparse Graph is " + cost_timeForSparse + " s");


    }


    static void path(int[][] P, int q, int r) {
        if (P[q][r] != 0) {
            path(P, q, P[q][r]);
            System.out.print("V" + (P[q][r] + 1) + "->");
            path(P, P[q][r], r);
        }
    }

    static void dijkstra(int vertices, int[][] adjacencyMatrix) {
        int[][] P = new int[vertices][vertices];
        int storeLength[] = new int[vertices];
        int vnear = 0;
        int[] length = new int[vertices];
        // int v = startVertex-1;
        for (int v = 0; v < vertices; v++) {
            for (int i = 0; i <= vertices - 1; i++) {
                length[i] = adjacencyMatrix[v][i];
            }

            for (int j = 0; j <= vertices - 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i <= vertices - 1; i++) {
                    if (length[i] >= 0 && length[i] < min) {
                        min = length[i];
                        vnear = i;
                    }

                }

                for (int i = 0; i <= vertices - 1; i++) {
                    if ((length[vnear] + adjacencyMatrix[vnear][i]) < 0) {//check overflow
                        continue;
                    }
                    if ((length[vnear] + adjacencyMatrix[vnear][i]) < length[i]) {
                        length[i] = length[vnear] + adjacencyMatrix[vnear][i];
                        P[v][i] = vnear;
                    }
                }
                storeLength[vnear] = length[vnear];//store the shortest distance from start to vnear
                length[vnear] = -1;
            }

//output path and distance

          for (int j = 0; j < vertices; j++) {
                if (v == j) continue;
                System.out.println("From V" + (v + 1) + " to V" + (j + 1) + " is ");
                System.out.print("V" + (v + 1) + "->");
                path(P, v, j);
                System.out.println("V" + (j + 1));
                System.out.println("The distance is " + storeLength[j]);

            }
        }
    }
}







