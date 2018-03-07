package Project_2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyListForFloyd {

    public static void main(String[] args) {
       System.out.println("Input the number of vertices for Complete graph (Floyd) Data Structure LinkedList");
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        int u, v, weight;

        AdjacencyListForGraph adjacencyList = new AdjacencyListForGraph(vertices);
        long startForComplete = System.currentTimeMillis();
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
        floyd(vertices, adjacencyList.adjacencyList);

        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Complete Graph is " + cost_timeForComplete + " s");


        System.out.println("Input the number of vertices for Sparse graph (Floyd) Data Structure LinkedList");
        int verticesForSparse = vertices;
        s.close();
        AdjacencyListForGraph adjacencyListForSparseGraph = new AdjacencyListForGraph(verticesForSparse);
        long startForSparse = System.currentTimeMillis();
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


        floyd(verticesForSparse, adjacencyListForSparseGraph.adjacencyList);
        long endForSparse = System.currentTimeMillis();
        long cost_timeForSparse = (endForSparse - startForSparse) / (1000);//calculate duration time(unit ms)
        System.out.println("Cost Time For Sparse Graph is " + cost_timeForSparse + " s");

    }


    static void floyd(int vertices, LinkedList<Pair<Integer, Integer>>[] adjacencyList) {
        LinkedList<Pair<Integer, Integer>>[] dist = adjacencyList;
        int[][] P = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                P[i][j] = 0;

            }
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if ((dist[i].get(k).getValue() + dist[k].get(j).getValue()) < 0) {//check overflow
                        continue;
                    }

                    if (dist[i].get(j).getValue() > dist[i].get(k).getValue() + dist[k].get(j).getValue()) {
                        P[i][j] = k;
                        int tmp = dist[i].get(k).getValue() + dist[k].get(j).getValue();
                        dist[i].set(j, new Pair<>(j, tmp));

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
                System.out.println("The distance is " + dist[i].get(j).getValue());
            }


        }
    }

    static void path(int[][] P, int q, int r) {
        if (P[q][r] != 0) {
            path(P, q, P[q][r]);
            System.out.print("V" + (P[q][r] + 1) + "->");
            path(P, P[q][r], r);

        }
    }
}
