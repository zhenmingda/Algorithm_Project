package Project_2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyListForDijkstra {
    public static void main(String[] args) {
        System.out.println("Input the number of vertices for Testcase 1 graph (Dijkstra) Data Structure LinkedList");
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        int u, v, weight;

        AdjacencyListForGraph adjacencyList = new AdjacencyListForGraph(vertices);
        long startForComplete = System.currentTimeMillis();

//generate graph
        for (u = 0; u < vertices; u++) {
            for (v = 0; v < vertices; v++) {
                if (u == v) {
                    adjacencyList.addEdge(u, v, 0);
                    continue;
                }
                java.util.Random random = new java.util.Random();
                weight = random.nextInt(vertices) + 1;
                if (u > v) {
                    adjacencyList.addEdge(u, v, adjacencyList.getEdgesFromVertex(v).get(u).getValue());
                } else {
                    adjacencyList.addEdge(u, v, weight);
                }
            }
        }


        dijkstra(vertices, adjacencyList.adjacencyList);
        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Complete Graph is " + cost_timeForComplete + " s");
        System.out.println("Input the number of vertices for Sparse graph (Dijkstra) Data Structure LinkedList");
        int verticesForSparse = vertices;
        s.close();
        AdjacencyListForGraph adjacencyListForSparseGraph = new AdjacencyListForGraph(verticesForSparse);
        long startForSparse = System.currentTimeMillis();
        //generate sparse graph like 1->2->3->
        for (u = 0; u < verticesForSparse; u++) {
            for (v = 0; v < verticesForSparse; v++) {
                if (u == v) {
                    adjacencyListForSparseGraph.addEdge(u, v, 0);
                    continue;
                }
                java.util.Random random = new java.util.Random();
                weight = random.nextInt(verticesForSparse) + 1;
                if (u - v == 1) {
                    adjacencyListForSparseGraph.addEdge(u, v, adjacencyListForSparseGraph.getEdgesFromVertex(v).get(u).getValue());
                    continue;
                }

                if (v - u == 1) {
                    adjacencyListForSparseGraph.addEdge(u, v, weight);
                    continue;
                }
                adjacencyListForSparseGraph.addEdge(u, v, Integer.MAX_VALUE);

            }
        }
        dijkstra(verticesForSparse, adjacencyListForSparseGraph.adjacencyList);
        long endForSparse = System.currentTimeMillis();
        long cost_timeForSparse = (endForSparse - startForSparse) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Sparse Graph is " + cost_timeForSparse + " s");

    }


    private static void path(int[][] P, int q, int r) {
        if (P[q][r] != 0) {
            path(P, q, P[q][r]);
            System.out.print("V" + (P[q][r] + 1) + "->");
            path(P, P[q][r], r);
        }
    }

    private static void dijkstra(int vertices, LinkedList<Pair<Integer, Integer>>[] adjacencyList) {
        int[][] P = new int[vertices][vertices];
        int storeLength[] = new int[vertices];
        int vnear = 0;
        int[] length = new int[vertices];
        for (int v = 0; v < vertices; v++) {
            for (int i = 0; i <= vertices - 1; i++) {
                length[i] = adjacencyList[v].get(i).getValue();
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
                    if ((length[vnear] + adjacencyList[vnear].get(i).getValue()) < 0) {//check overflow
                        continue;
                    }
                    if ((length[vnear] + adjacencyList[vnear].get(i).getValue()) < length[i]) {
                        length[i] = length[vnear] + adjacencyList[vnear].get(i).getValue();
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


