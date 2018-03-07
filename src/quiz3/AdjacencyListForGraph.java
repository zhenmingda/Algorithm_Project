package quiz3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyListForGraph {
    LinkedList<Integer>[] adjacencyList;

    public AdjacencyListForGraph(int vertices) {
        adjacencyList = (LinkedList<Integer>[]) new LinkedList[vertices];
        for (int i = 0; i <= 7; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
        adjacencyList[0].add(3);
        adjacencyList[0].add(null);//1

        adjacencyList[3].add(0);
        adjacencyList[3].add(4);//4
        adjacencyList[3].add(2);
        adjacencyList[3].add(6);
        adjacencyList[3].add(null);

        adjacencyList[4].add(3);//5
        adjacencyList[4].add(6);
        adjacencyList[4].add(7);
        adjacencyList[4].add(null);

        adjacencyList[2].add(3);//3
        adjacencyList[2].add(6);
        adjacencyList[2].add(5);
        adjacencyList[2].add(null);

        adjacencyList[6].add(4);//7
        adjacencyList[6].add(3);
        adjacencyList[6].add(2);
        adjacencyList[6].add(1);
        adjacencyList[6].add(null);

        adjacencyList[7].add(5);//8

        adjacencyList[7].add(4);
        adjacencyList[7].add(null);

        adjacencyList[5].add(2);
        adjacencyList[5].add(7);//6
        adjacencyList[5].add(1);
        adjacencyList[5].add(null);

        adjacencyList[1].add(5);//2
        adjacencyList[1].add(6);
        adjacencyList[1].add(null);
    }

    public static void main(String[] args) {
        AdjacencyListForGraph adjacencyListForGraph = new AdjacencyListForGraph(8);

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if(i==j){
                    continue;
                }
                shortPath(i, j, adjacencyListForGraph.adjacencyList);
            }
        }

    }

    private static void shortPath(int i, int j, LinkedList<Integer>[] adjacencyList) {
        int startVertex = i - 1;
        int endVertex = j - 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        int visit[] = new int[8];
        for (int l = 0; l < visit.length; l++) {
            visit[l] = 0;
        }

        int count = 0;
        queue.add(startVertex);
        visit[startVertex] = 1;

        //level 1
        Integer node = queue.remove();

        for (int k = 0; k < adjacencyList[node].size() - 1; k++) {
            if (visit[adjacencyList[node].get(k)] == 1) {
                continue;
            }
            queue.add(adjacencyList[node].get(k));
            visit[adjacencyList[node].get(k)] = 1;
            if (adjacencyList[node].get(k) == endVertex) {
                count = 1;
                printDistance(startVertex, endVertex, count);
            }
        }

//level 2

        int enqueueNumber = queue.size();
        for (int en = 0; en < enqueueNumber; en++) {
            node = queue.remove();
            for (int k = 0; k < adjacencyList[node].size() - 1; k++) {
                if (visit[adjacencyList[node].get(k)] == 1) {
                    continue;
                }
                queue.add(adjacencyList[node].get(k));
                visit[adjacencyList[node].get(k)] = 1;
                if (adjacencyList[node].get(k) == endVertex) {
                    count = 2;
                    printDistance(startVertex, endVertex, count);
                }
            }
        }

//level 3
        enqueueNumber = queue.size();
        for (int en = 0; en < enqueueNumber; en++) {
            node = queue.remove();
            for (int k = 0; k < adjacencyList[node].size() - 1; k++) {
                if (visit[adjacencyList[node].get(k)] == 1) {
                    continue;
                }
                queue.add(adjacencyList[node].get(k));
                visit[adjacencyList[node].get(k)] = 1;
                if (adjacencyList[node].get(k) == endVertex) {
                    count = 3;
                    printDistance(startVertex, endVertex, count);
                }
            }
        }
    }

    private static void printDistance(int startVertex, int endVertex, int count) {
        int s = startVertex + 1;
        int e = endVertex + 1;
        System.out.println("v" + s + " - " + "v" + e + " : " + count);
    }
}

