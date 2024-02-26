import source.Salamancas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // var result=Search.binary(new int[]{2,5,7,8,9,12,14,17,19,22,25,27,28,33,37},5,0,14);
        // System.out.println(result);

        //var res=PrefixAverage.calculate(new int[]{6,2,3,4});
        //System.out.println(res[0]);

        Scanner scanner = new Scanner(System.in);
        //Salamancas.StartListening(scanner);
        //Salamancas.StartListeningRecursive(scanner);
        Salamancas.StartListeningByTableOfAlphabet(scanner);

    }
}
