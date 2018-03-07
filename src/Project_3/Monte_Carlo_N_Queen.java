package Project_3;

import java.util.LinkedList;

public class Monte_Carlo_N_Queen {
    int col[];

    public Monte_Carlo_N_Queen() {
        col = new int[8];

    }

    public static void main(String[] args) {

        int count = 0;
        for (int i = 1; i <= 20; i++) {
            Monte_Carlo_N_Queen monte_carlo_n_queen = new Monte_Carlo_N_Queen();
            int nodes = monte_carlo_n_queen.estimate_n_queens(8);
            System.out.println("The number of nodes is " + nodes);
            count += nodes;
        }
        System.out.println("The average is " + count / 20);
    }


    boolean promising(int i) {

        int k = 0;
        boolean sw = true;
        while (k < i && sw) {
            if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k) {
                sw = false;
            }
            k++;
        }
        return sw;

    }

    private int estimate_n_queens(int n) {
        LinkedList prom_children = new LinkedList();
        int i = -1;
        int j = 0;
        int m = 1;
        int mprod = 1;
        int numnodes = 1;

        while (m != 0 && i != n - 1) {
            mprod = mprod * m;
            numnodes = numnodes + mprod * n;
            i++;
            m = 0;
            for (j = 0; j < n; j++) {
                col[i] = j;
                if (promising(i)) {
                    m++;
                    prom_children.add(j);

                }
            }
            if (m != 0) {
                java.util.Random random = new java.util.Random();
                j = (int) prom_children.get(random.nextInt(prom_children.size()));
                col[i] = j;
            }

        }
        return numnodes;
    }
}
