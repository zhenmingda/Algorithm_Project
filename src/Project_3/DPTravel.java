package Project_3;

import java.util.ArrayList;
import java.util.HashMap;


public class DPTravel {
    private int[][] graph;
    HashMap<Integer, ArrayList<Integer>> id_set = new HashMap<Integer, ArrayList<Integer>>();
    //get subset by id
    HashMap<ArrayList<Integer>, Integer> set_id = new HashMap<ArrayList<Integer>, Integer>();

    //get id by subset
    public DPTravel(int[][] graph) {
        this.graph = graph;
    }


    public int DP() {
        int n = graph.length;
        int[] vertex = new int[n - 1];
        int vertexid = 1;
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] = vertexid;
            vertexid++;
        }
        getsubsets(vertex);
        int[][] DISTANCE = new int[n][set_id.size()];// the distance
        int[][] Path = new int[n][set_id.size()];// the path

        for (int i = 1; i < n; i++) {
            DISTANCE[i][0] = this.graph[i][0];
        }
        for (int k = 1; k <= n - 2; k++) {
            for (int id = 0; id < id_set.size(); id++) {
                ArrayList<Integer> subset = id_set.get(id);
                if (subset.size() != k)
                    continue;
                for (int i = 1; i < n; i++) {
                    if (subset.contains(i))
                        continue;
                    int min = Integer.MAX_VALUE;
                    int value = 0;
                    for (int j : subset) {
                        ArrayList<Integer> Aminusj = remove(subset, j);
                        int idj = set_id.get(Aminusj);
                        value = this.graph[i][j] + DISTANCE[j][idj];
                        if (value < min && value != 0) {
                            min = value;
                            Path[i][id] = j;
                        }
                    }
                    DISTANCE[i][id] = min;
                }
            }
        }
        ArrayList<Integer> Vexv0 = new ArrayList<Integer>();
        for (int i = 0; i < vertex.length; i++) {
            Vexv0.add(vertex[i]);
        }
        int vexv0 = set_id.get(Vexv0);
        int min = Integer.MAX_VALUE;
        for (int j : Vexv0) {
            ArrayList<Integer> Vminusv0vj = remove(Vexv0, j);
            int idj = set_id.get(Vminusv0vj);

            int value = 0;
            if (this.graph[0][j] != 0 && DISTANCE[j][idj] != 0) {
                value = this.graph[0][j] + DISTANCE[j][idj];
            }


            if (value < min && value != 0) {
                min = value;
                Path[0][vexv0] = j;
            }
        }
        DISTANCE[0][vexv0] = min;
        generateOpttour(Path, Vexv0);
        return DISTANCE[0][vexv0];
    }


    //list containing all vertexes   except V0

    public void generateOpttour(int[][] P, ArrayList<Integer> V) {
        String path = "1->";
        ArrayList<Integer> Set = V;
        int start = 0;
        while (!Set.isEmpty()) {
            int id = set_id.get(Set);
            String vertex = String.valueOf(P[start][id] + 1);
            path += vertex + "->";
            Set = remove(Set, P[start][id]);
            start = P[start][id];
        }
        path += "1";
        System.out.println(path);
    }


    private void getsubsets(int[] set) {
        id_set.clear();
        set_id.clear();
        int max = 1 << set.length; //how many sub sets=2^set.length
        int id = 0;
        for (int i = 0; i < max; i++) {
            int index = 0;
            int k = i;
            ArrayList<Integer> s = new ArrayList<Integer>();
            while (k > 0) {
                if (k % 2 != 0) {
                    s.add(set[index]);
                }
                k = k / 2;
                index++;
            }
            id_set.put(id, s);
            set_id.put(s, id);
            id++;
        }
    }

    //remove the certain vertex
    private ArrayList<Integer> remove(ArrayList<Integer> src, int n) {
        ArrayList<Integer> dest = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < src.size(); i++) {
            int vertex = src.get(i);
            if (vertex == n)
                continue;
            dest.add(vertex);
        }
        return dest;
    }

    public static void main(String[] args) {
        int n;
        for (n = 3; n <= 23; n++) {
            System.out.println("n= "+n);
            int W[][] = generateGraph(n);

            DPTravel test = new DPTravel(W);
            long startForComplete = System.currentTimeMillis();
            int distance = test.DP();
            System.out.println("Min Length is " + distance);
            long endForComplete = System.currentTimeMillis();
            long cost_timeForComplete = (endForComplete - startForComplete);//calculate duration time(unit ms)
            System.out.println("Cost Time is " + cost_timeForComplete + " ms");
        }
    }


    static int[][] generateGraph(int vertices) {


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