package Project_3;

import java.util.*;

public class BranchAndBoundTravel {
    public static void main(String[] args) {
        int n;
        for (n = 3; n < 12; n++) {
            int W[][] = generateGraph(n);

            long startForComplete = System.currentTimeMillis();
            System.out.println("n= " + n);
            travel2(n, W);
            System.out.println();
            long endForComplete = System.currentTimeMillis();
            long cost_timeForComplete = (endForComplete - startForComplete);//calculate duration time(unit ms)
            System.out.println("Cost Time is " + cost_timeForComplete + " ms");
        }
    }

    static void travel2(int n, int[][] W) {


        ArrayList<Integer> opttour = new ArrayList<>();
        Queue<node> PQ = new LinkedList<>();
        node u;
        node v = new node(0);
        v.path.add(0);
        v.bound = bound(v, n, W);

        int minLength = Integer.MAX_VALUE;
        PQ.add(v);
        while (!PQ.isEmpty()) {
            node x = PQ.remove();

            if (x.bound < minLength) {

                for (int i = 0; i < n; i++) {
                    if (i >= 1 && i <= n - 1 && !x.path.contains(i)) {

                        u=new node(x.level+1);
                        for (int j = 0; j < x.path.size(); j++) {
                            int vertex = x.path.get(j);
                            u.path.add(vertex);
                        }
                        u.path.add(i);//put AT THE END
                        if (u.level == n - 2) {
                            for (int number = 0; number < n; number++) {
                                if (!u.path.contains(number)) {
                                    u.path.add(number);
                                }
                            }
                            u.path.add(0);//put the first at the end
                            int length = length(u, W);
                            if (length < minLength) {
                                minLength = length;
                                //opttour.clear();
                                opttour = u.path;
                            }
                        } else {
                            u.bound = bound(u, n, W);
                            if (u.bound < minLength) {
                                PQ.add(u);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The minlength is " + minLength);

        System.out.print("The path is ");
        for (int p : opttour) {
            System.out.print((p + 1) + " ");
        }
    }


    private static int length(node u, int[][] W) {
        int length = 0;
        for (int i = 0; i < u.path.size() - 1; i++) {
            length += W[u.path.get(i)][u.path.get(i + 1)];
        }
        return length;
    }

    private static int bound(node v, int n, int[][] W) {

        ArrayList<Integer> path = v.path;
        int bound = 0;
        //from 1 to intermediate
        for (int i = 0; i < path.size() - 1; i++) {

            bound += W[path.get(i)][path.get(i + 1)];
        }
//intermediate!!!

        int minValue = getMin(W[path.get(path.size() - 1)], path);
        bound += minValue;
//754S
//the rest!!!
        for (int i = 0; i < n; i++) {
            if (path.contains(i)) {
                continue;
            }

            minValue = getMinRest(W[i], path);
            bound += minValue;
        }
        return bound;
    }

    private static int getMin(int[] array, ArrayList<Integer> path) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (path.contains(i)) {
                continue;
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }


    private static int getMinRest(int[] array, ArrayList<Integer> path) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (path.contains(i) && i != 0) {
                continue;
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
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
                    adjacencyMatrix[u][v] = Integer.MAX_VALUE;
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

class node {
    int level;
    ArrayList<Integer> path;
    int bound;
    node(int level){
        this.level=level;
        path = new ArrayList<>(this.level+1);
    }
}