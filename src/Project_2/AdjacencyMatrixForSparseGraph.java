package Project_2;

/**
 * Created by dashu on 10/11/2017.
 */
public class AdjacencyMatrixForSparseGraph {

    int[][] generateGraph(int vertices) {

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
                if (v - u == 1) {
                    adjacencyMatrix[u][v] = weight;
                    continue;
                }
                if (u - v == 1) {
                    adjacencyMatrix[u][v] = adjacencyMatrix[v][u];
                    continue;
                }
                adjacencyMatrix[u][v] = Integer.MAX_VALUE;
            }
        }
        return adjacencyMatrix;
    }
}
