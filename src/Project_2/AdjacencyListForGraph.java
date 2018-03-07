package Project_2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyListForGraph {
    LinkedList<Pair<Integer, Integer>>[] adjacencyList;

    // Constructor
    public AdjacencyListForGraph(int vertices) {
        adjacencyList = (LinkedList<Pair<Integer, Integer>>[]) new LinkedList[vertices];

        for (int i = 0; i < adjacencyList.length; ++i) {
            adjacencyList[i] = new LinkedList<Pair<Integer, Integer>>();
        }
    }

    // Appends a new Edge to the linked list
    public void addEdge(int startVertex, int endVertex, int weight) {
        adjacencyList[startVertex].add(new Pair<>(endVertex, weight));
    }

    public boolean removeEdge(int startVertex, Pair<Integer, Integer> edge) {
        return adjacencyList[startVertex].remove(edge);
    }

    // Returns a copy of the Linked List of outward edges from a vertex
    public LinkedList<Pair<Integer, Integer>> getEdgesFromVertex(int startVertex) {
        LinkedList<Pair<Integer, Integer>> edgeList
                = (LinkedList<Pair<Integer, Integer>>) new LinkedList(adjacencyList[startVertex]);

        return edgeList;
    }



}
