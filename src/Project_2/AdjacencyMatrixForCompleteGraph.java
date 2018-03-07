package Project_2;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyMatrixForCompleteGraph {


    int[][] generateGraph(int vertices) {


        long start = System.currentTimeMillis();
        int edges = vertices * (vertices - 1) / 2;
        int u, v;
        java.util.Random random = new java.util.Random();
        int weight = random.nextInt(vertices) + 1;
        int[][] adjacencyMatrix = new int[vertices][vertices];
        for (u = 0; u < vertices; u++) {
            for (v = 0; v < vertices; v++) {
                weight = random.nextInt(vertices) + 1;
                if (u == v) {
                    adjacencyMatrix[u][v] = 0;
                    continue;
                }
                if (u < v) {
                    adjacencyMatrix[u][v] = weight;
                } else {
                    adjacencyMatrix[u][v] = adjacencyMatrix[v][u];
                }
            }
        }


        return adjacencyMatrix;
    }

}












