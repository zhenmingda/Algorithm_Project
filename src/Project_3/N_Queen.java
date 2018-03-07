package Project_3;

public class N_Queen {
    int n;
    int[] col;

    public static void main(String[] args) {

        N_Queen n_queen4 = new N_Queen(4);
        System.out.println("N=4");
        n_queen4.queens(-1);
        N_Queen n_queen8 = new N_Queen(8);
        System.out.println("N=8");
        n_queen8.queens(-1);
        N_Queen n_queen10 = new N_Queen(10);
        System.out.println("N=8");
        n_queen10.queens(-1);
        N_Queen n_queen12 = new N_Queen(12);
        System.out.println("N=12");
        n_queen12.queens(-1);
    }

    private void queens(int i) {
        int j = 0;
        if (promising(i)) {
            if (i == n - 1) {
                for (int index = 0; index < n; index++) {
                    System.out.println("The Row and Column are " + (index + 1) + " " + (col[index] + 1));
                    if (index == n - 1) {
                        System.out.println();
                    }
                }

            } else {
                for (j = 0; j < n; j++) {
                    col[i + 1] = j;
                    queens(i + 1);
                }

            }
        }


    }

    private boolean promising(int i) {

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

    public N_Queen(int n) {
        this.n = n;
        col = new int[n];
    }
}
