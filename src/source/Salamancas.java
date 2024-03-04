package source;
import java.util.Scanner;

public class Salamancas {
    private static StringBuilder message = new StringBuilder();

    private static String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    private static char[] alphabetArray = {'a', 'b', 'c', 'd', 'e','f', 'g', 'h', 'i', 'j','k', 'l', 'm', 'n', 'o','p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y','z'};
    private static char[][] alphabetTable = {{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j'}, {'k', 'l', 'm', 'n', 'o'}, {'p', 'q', 'r', 's', 't'}, {'u', 'v', 'w', 'x', 'y'}};
    public static void StartListening(Scanner scanner) {
        for (int i = 0; i < alphabetString.length(); i++) {
            if(message.length()<10) {
                System.out.print("Hector, is it the letter '" + alphabetString.charAt(i) + "'? (*Ding* for yes, any other key for no): ");
                char response = scanner.next().toLowerCase().charAt(0);

                if (response == 'r') {
                    message.append(alphabetString.charAt(i));
                    i = -1;
                }
            }
        }
        System.out.println("Hector's message: " + message.toString());
    }
    public static void StartListeningWithNumbers(Scanner scanner) {
        System.out.print("The length of the word is: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++)
        {
            int pivotIndex= alphabetArray.length/2;
            for (int j = alphabetString.length()/2; j > 0; j=j/2){
                System.out.print("Eduardo, is the letter: "+ alphabetArray[pivotIndex]+" type (-1/0/1) for(less/equal/great)");

                String response = scanner.next().toLowerCase();
                if(j==1){
                    message.append(alphabetArray[pivotIndex]);
                }
                else if(response.equals("-1")){
                    pivotIndex=pivotIndex-j/2-1;
                    System.out.print("Eduardo, is the letter: "+ alphabetArray[pivotIndex]+" type (-1/0/1) for(less/equal/great)");
                    //to do check if pivot less than equal '0'
                }
                else if(response.equals("0")){
                    message.append(alphabetArray[pivotIndex]);
                }
                else if(response.equals("1")){
                    pivotIndex=pivotIndex+j/2+1;
                    System.out.print("Eduardo, is the letter: "+ alphabetArray[pivotIndex]+" type (-1/0/1) for(less/equal/great)");
                    //to do check if pivot greater than length of alphabetArray
                }

            }
            int row = i / length;
            int col = i % length;
            System.out.print(alphabetTable[row][col] + " ");
        }
        System.out.println("Hector's message: " + message.toString());
    }
    public static void StartListeningRecursive(Scanner scanner) {
        System.out.print("Hector message is: " + Execute( scanner, message, 0));
    }
    private static StringBuilder Execute(Scanner scanner, StringBuilder message,int alphabetIndex){
        if (alphabetIndex< alphabetString.length()&&message.length()<10) {
            System.out.print("Hector, is it the letter '" + alphabetString.charAt(alphabetIndex) + "'? (input 'r' for yes, any other key for no): ");
            char response = scanner.next().toLowerCase().charAt(0);

            if (response == 'r') {
                message.append(alphabetString.charAt(alphabetIndex));
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

        for (int i = 0; i < Math.pow((double)(alphabetArray.length),2); i++) {
            if(message.length()<10){
                int row = i / alphabetArray.length;
                int col = i % alphabetArray.length;

                if (i % alphabetArray.length==0)
                {
                    System.out.println("Is it the letter in row '" + alphabetTable[row][col] + "'? (*Ding* for yes, any other key for no): ");
                    response = scanner.next().toLowerCase().charAt(0);
                    if (response!='r'){
                        i=i-1+ alphabetArray.length;
                    }
                    else if(response=='r')
                    {
                        System.out.println("Is it the letter '" + alphabetTable[row][col] + "'? (*Ding* for yes, any other key for no): ");
                        response = scanner.next().toLowerCase().charAt(0);
                        if (response=='r'){
                            message.append(alphabetTable[row][col]);
                            i=-1;
                        }
                    }
                }
                else if (i % alphabetArray.length!=0) {
                    System.out.println("Is it the letter '" + alphabetTable[row][col] + "'? (*Ding* for yes, any other key for no): ");
                    response = scanner.next().toLowerCase().charAt(0);
                    if (response=='r'){
                        message.append(alphabetTable[row][col]);
                        i=-1;
                    }
                }
            }
        }
        System.out.println("Hector's message: " + message.toString());
    }
}
