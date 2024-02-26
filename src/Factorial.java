public class Factorial {
    public static int calculate(int n){
        if(n<=0)
            return 1;
        else
            return n*calculate(n-1);
    }
    public static int factorial(int n)throws IllegalArgumentException
    {
        if(n<0)
            throw new IllegalArgumentException();
        else if(n==0)
            return 1;
        else
            return n* factorial(n-1);
    }
}
