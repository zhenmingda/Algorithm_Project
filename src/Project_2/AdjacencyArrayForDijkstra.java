package Project_2;

import java.util.Scanner;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyArrayForDijkstra {
    public static void main(String[] args) {
        System.out.println("Input the number of vertices for Testcase 1 graph (Dijkstra) Data Structure one dimmensional array");
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        AdjacencyArrayForCompleteGraph graph = new AdjacencyArrayForCompleteGraph();
        long startForComplete = System.currentTimeMillis();
        int[] adjacencyArray = graph.generateGraph(vertices);
        dijkstra(vertices, adjacencyArray);


        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Complete Graph is " + cost_timeForComplete + " s");
        System.out.println("Input the number of vertices for Sparse graph (Dijkstra) Data Structure one dimmensional array");
        int verticesForSparse = vertices;
        s.close();
        AdjacencyArrayForSparseGraph sparseGraph = new AdjacencyArrayForSparseGraph();
        long startForSparse = System.currentTimeMillis();
        int[] adjacencyArrayForSparse = sparseGraph.generateGraph(verticesForSparse);//generate graph
        dijkstra(verticesForSparse, adjacencyArrayForSparse);
        long endForSparse = System.currentTimeMillis();
        long cost_timeForSparse = (endForSparse - startForSparse) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Sparse Graph is " + cost_timeForSparse + " s");

    }



//print intermediate path
    static void path(int[][] P, int q, int r) {
        if (P[q][r] != 0) {
            path(P, q, P[q][r]);
            System.out.print("V" + (P[q][r] + 1) + "->");
            path(P, P[q][r], r);

        }
    }

    static void dijkstra(int vertices, int[] adjacencyArray) {
        int[][] P = new int[vertices][vertices];
        int storeLength[] = new int[vertices];
        int vnear = 0;
        int edge = 0;
        int[] length = new int[vertices];
        for (int v = 0; v < vertices; v++) {

            for (int i = 0; i <= vertices - 1; i++) {
                //touch[i] = 1;
                if (v == i) {
                    length[i] = 0;
                }
                if (v < i) {
                    length[i] = adjacencyArray[(i * (i - 1) / 2) + v];
                }
                if (v > i) {
                    length[i] = adjacencyArray[(v * (v - 1) / 2) + i];
                }
                if (v == 0) {
                    length[0] = 0;
                }
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

                    if (vnear == i) {
                        continue;
                    }
                    if (vnear < i) {

                        if ((length[vnear] + adjacencyArray[(i * (i - 1) / 2) + vnear]) < 0) {//int overflow from + to -
                            continue;
                        }
                        if ((length[vnear] + adjacencyArray[(i * (i - 1) / 2) + vnear]) < length[i]) {
                            length[i] = length[vnear] + adjacencyArray[(i * (i - 1) / 2) + vnear];
                            P[v][i] = vnear;
                        }


                    }
                    if (vnear > i) {
                        if ((length[vnear] + adjacencyArray[(vnear * (vnear - 1) / 2) + i]) < 0) {//int overflow from + to -
                            continue;
                        }
                        if ((length[vnear] + adjacencyArray[(vnear * (vnear - 1) / 2) + i]) < length[i]) {
                            length[i] = length[vnear] + adjacencyArray[(vnear * (vnear - 1) / 2) + i];
                            P[v][i] = vnear;
                        }
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

