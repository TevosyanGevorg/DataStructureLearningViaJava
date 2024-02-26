public class PrefixAverage {
    public static int[] calculate(int []x){
        int n=x.length;
        int [] a=new int[n];
        for (int j=0;j<n;j++){
            int total =0;
            for (int i=0;i<=j;i++){
                total+=x[i];
                a[j]=total/j+1;
            }
        }
        return a;
    }
}
