package source.HomeWorks.HomeworkAssignment_1;
import java.util.Scanner;

public class Salamancas {
    private static StringBuilder message = new StringBuilder();

    private static String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    private static char[] alphabetArray = {'a', 'b', 'c', 'd', 'e','f', 'g', 'h', 'i', 'j','k', 'l', 'm', 'n', 'o','p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y'};
    private static char[][] alphabetTable = {{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j'}, {'k', 'l', 'm', 'n', 'o'}, {'p', 'q', 'r', 's', 't'}, {'u', 'v', 'w', 'x', 'y'}};
    public static void StartListeningHectorN(Scanner scanner) {
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
    public static void StartListeningHector(Scanner scanner) {
        System.out.print("Hector message is: " + StartListeningHectorRecursively( scanner, message, 0));
    }
    private static StringBuilder StartListeningHectorRecursively(Scanner scanner, StringBuilder message, int alphabetIndex){
        if (alphabetIndex< alphabetString.length()&&message.length()<10) {
            System.out.print("Hector, is it the letter '" + alphabetString.charAt(alphabetIndex) + "'? (input 'r' for yes, any other key for no): ");
            char response = scanner.next().toLowerCase().charAt(0);

            if (response == 'r') {
                message.append(alphabetString.charAt(alphabetIndex));
                StartListeningHectorRecursively(scanner, message, 0);

            } else{
                StartListeningHectorRecursively(scanner, message, alphabetIndex + 1);
            }
        }
        return message;
    }
    public static void StartListeningHectorByTableOfAlphabet(Scanner scanner) {
        System.out.print("Hector, are you here? (*Ding* for yes, any other key for no): ");
        char response = scanner.next().toLowerCase().charAt(0);

        for (int i = 0; i < Math.pow((double)(alphabetTable.length),2); i++) {
            if(message.length()<10){
                int row = i / alphabetTable.length;
                int col = i % alphabetTable.length;

                if (i % alphabetTable.length==0)
                {
                    System.out.println("Is it the letter in row '" + alphabetTable[row][col] + "'? (*Ding* for yes, any other key for no): ");
                    response = scanner.next().toLowerCase().charAt(0);
                    if (response!='r'){
                        i=i-1+ alphabetTable.length;
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
                else if (i % alphabetTable.length!=0) {
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
    public static void StartListeningEduardo(Scanner scanner) {
        System.out.print("Lalo, please print lengthOfWord: ");
        int lengthOfWord = scanner.nextInt();
        for (int i = 0; i < lengthOfWord; i++)
        {
            StartListeningEduardoRecursively(scanner,alphabetArray,alphabetArray.length/2);
        }
        System.out.print("Eduardo's message: " + message.toString());
    }
    private static  void StartListeningEduardoRecursively(Scanner scanner, char[] alphabetArray, int pivotIndex){
        if ((pivotIndex==alphabetArray.length-1)||(pivotIndex==-1))
        {
            System.out.println("Letters END: ");
            return;
        }

        System.out.println("Lalo, how about the letter: "+ alphabetArray[pivotIndex]+" print (-1/0/1) for(less/equal/great)");
        String response = scanner.next();
        if(response.equals("0"))
        {
            message.append(alphabetArray[pivotIndex]);
            return;
        }
        else if(response.equals("-1"))
        {
            pivotIndex=(pivotIndex==0)
                    ?-1
                    :pivotIndex/2;
        }
        else if(response.equals("1"))
        {
            pivotIndex=((((alphabetArray.length-1)-pivotIndex)/2)==0)
                    ?alphabetArray.length-1
                    :(((alphabetArray.length-1)-pivotIndex)/2)+pivotIndex;
        }
        StartListeningEduardoRecursively(scanner,alphabetArray, pivotIndex);

    }
}
