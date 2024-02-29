package source;
import java.util.Scanner;

public class Salamancas {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static StringBuilder message = new StringBuilder();
    private static char[][] tableOfAlphabet = {{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j'}, {'k', 'l', 'm', 'n', 'o'}, {'p', 'q', 'r', 's', 't'}, {'u', 'v', 'w', 'x', 'y'}};
    public static void StartListening(Scanner scanner) {
        for (int i = 0; i < alphabet.length(); i++) {
            if(message.length()<10) {
                System.out.print("Hector, is it the letter '" + alphabet.charAt(i) + "'? (*Ding* for yes, any other key for no): ");
                char response = scanner.next().toLowerCase().charAt(0);

                if (response == 'r') {
                    message.append(alphabet.charAt(i));
                    i = -1;
                }
            }
        }
        System.out.println("Hector's message: " + message.toString());
    }
    public static void StartListeningWithNumbers(Scanner scanner) {
        System.out.print("The length of the word is: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length * length; i++)
        {
            int row = i / length;
            int col = i % length;
            System.out.print(tableOfAlphabet[row][col] + " ");
        }
        System.out.println("Hector's message: " + message.toString());
    }
    public static void StartListeningRecursive(Scanner scanner) {
        System.out.print("Hector message is: " + Execute( scanner, message, 0));
    }
    private static StringBuilder Execute(Scanner scanner, StringBuilder message,int alphabetIndex){
        if (alphabetIndex<alphabet.length()&&message.length()<10) {
            System.out.print("Hector, is it the letter '" + alphabet.charAt(alphabetIndex) + "'? (input 'r' for yes, any other key for no): ");
            char response = scanner.next().toLowerCase().charAt(0);

            if (response == 'r') {
                message.append(alphabet.charAt(alphabetIndex));
                Execute(scanner, message, 0);

            } else{
                Execute(scanner, message, alphabetIndex + 1);
            }
        }
        return message;
    }
    public static void StartListeningByTableOfAlphabet(Scanner scanner) {
        System.out.print("Hector, are you here? (*Ding* for yes, any other key for no): ");
        char response = scanner.next().toLowerCase().charAt(0);

        for (int i = 0; i < Math.pow((double)(tableOfAlphabet.length),2); i++) {
            if(message.length()<10){
                int row = i / tableOfAlphabet.length;
                int col = i % tableOfAlphabet.length;

                if (i % tableOfAlphabet.length==0)
                {
                    System.out.println("Is it the letter in row '" + tableOfAlphabet[row][col] + "'? (*Ding* for yes, any other key for no): ");
                    response = scanner.next().toLowerCase().charAt(0);
                    if (response!='r'){
                        i=i-1+tableOfAlphabet.length;
                    }
                    else if(response=='r')
                    {
                        System.out.println("Is it the letter '" + tableOfAlphabet[row][col] + "'? (*Ding* for yes, any other key for no): ");
                        response = scanner.next().toLowerCase().charAt(0);
                        if (response=='r'){
                            message.append(tableOfAlphabet[row][col]);
                            i=-1;
                        }
                    }
                }
                else if (i % tableOfAlphabet.length!=0) {
                    System.out.println("Is it the letter '" + tableOfAlphabet[row][col] + "'? (*Ding* for yes, any other key for no): ");
                    response = scanner.next().toLowerCase().charAt(0);
                    if (response=='r'){
                        message.append(tableOfAlphabet[row][col]);
                        i=-1;
                    }
                }
            }
        }
        System.out.println("Hector's message: " + message.toString());
    }
}
