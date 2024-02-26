public class Fibonacci {
    public static double Calculate(int n){
        if(n<=1){
            return n;
        }
        else return Calculate(n-2)+ Calculate(n-1);
    }

    public static double [] CalculateGood(int n){
        if(n<=1){
            double[] answer={n,0};
            return answer;
        }
        else
        {
            double[]temp= CalculateGood(n-1);
            double[]answer= {temp[0]+temp[1],temp[0]};
            return answer;
        }
    }

}
