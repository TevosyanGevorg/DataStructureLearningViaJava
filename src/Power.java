public class Power {
    public static double ON(double x, int n){
        if (n==0) {
            return 1;
        }
        else {
            System.out.println(n+"*Power_ON");
            return x*ON(x, n-1);
        }
    }

    public static double OLogN(double x, int n){
        if (n==0) {
            return 1;
        }
        else {
            //System.out.println(x+"*Power_OLogN");
            double partial =OLogN(n, n/2);
            double result= partial*partial;
            if(n%2==1){
                result*=x;
            }
            return result;
        }
    }
}
