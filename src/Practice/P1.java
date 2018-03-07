package Practice;

public class P1 {
    public static void main(String[] args) {
       String []given_array={"1","2","3","4","5","6"};
       String []subset=new String[given_array.length];
      helper(given_array,subset,0);

    }

    private static void helper(String[] given_array, String[] subset, int i) {
        if (i==given_array.length){
            for(int j=0;j<subset.length;j++){
                if(subset[j]!=null){
                    System.out.print(subset[j]+" ");
                }
            }
            System.out.println();
        }else{
            subset[i]=null;
            helper(given_array,subset,i+1);
            subset[i]=given_array[i];
            helper(given_array,subset,i+1);
        }
    }
}
