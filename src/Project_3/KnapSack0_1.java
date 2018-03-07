package Project_3;

public class KnapSack0_1 {
    int numbest;
    int maxprofit;
    int n;
    int w[];
    int W;
    int[] p;
    String bestset[];

    String include[];

    public static void main(String[] args) {
        KnapSack0_1 knapSack0_1 = new KnapSack0_1();
        knapSack0_1.knaspsack(-1, 0, 0);
        System.out.println("Maxprofit is "+knapSack0_1.maxprofit);
        for(int j=0;j<knapSack0_1.bestset.length;j++){
            if (knapSack0_1.bestset[j]=="yes")
            System.out.println("The "+(j+1)+" item : "+knapSack0_1.bestset[j]);
        }
    }

    private void knaspsack(int i, int profit, int weight) {

        if (weight <= W && profit > maxprofit) {
            maxprofit = profit;
            numbest = i;
            for(int j=0;j<include.length;j++){
                bestset[j] = include[j];
            }

        }
        if (promising(i, weight, profit)) {
            include[i + 1] = "yes";
            knaspsack(i + 1, profit + p[i + 1], weight + w[i + 1]);
            include[i + 1] = "no";
            knaspsack(i + 1, profit, weight);

        }
    }

    private boolean promising(int i, int weight, int profit) {
        int j = 0;
        int k = 0;
        int totalweight = 0;
        float bound = 0;
        if (weight >= W) {
            return false;
        } else {
            j = i + 1;
            bound = profit;
            totalweight = weight;
            while (j <n && totalweight + w[j] <= W) {
                totalweight = totalweight + w[j];
                bound = bound + p[j];
                j++;
            }
            k = j;
            if (k < n) {
                bound = bound + (W - totalweight) * p[k] / w[k];

            }
            return bound > maxprofit;
        }

    }

    public KnapSack0_1() {
        numbest = 0;
        maxprofit = 0;
        n = 5;
        w = new int[n];
        w[0]=2;
        w[1]=5;
        w[2]=7;
        w[3]=3;
        w[4]=1;

        W = 9;
        p = new int[n];
        p[0]=20;
        p[1]=30;
        p[2]=35;
        p[3]=12;
        p[4]=3;
        bestset = new String[n];
        include = new String[n];

    }
}
