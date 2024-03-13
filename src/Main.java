import HomeWorks.HomeworkAssignment_1.LinkedMergeSort;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);

        //Salamancas.StartListeningHectorN(scanner);
        //Salamancas.StartListeningHector(scanner);
        //Salamancas.StartListeningHectorByTableOfAlphabet(scanner);
        //Salamancas.StartListeningEduardo(scanner);

        //Magnets.initializeMagnets(scanner);
        //Magnets.showMagnets();
        //Magnets.holdingMagnetAtTheLeftSide();
        //Magnets.showMagnets();

        //int[] integers=new int[]{ 38, 27, 43, 3, 9, 82, 10 };
        //MergeSort.mergeSort(integers);
        //for (int i = 0; i < integers.length; i++) {
        //    System.out.print(integers[i]+((i == integers.length-1)?"":", "));
        //}

        LinkedMergeSort linkedMergeSort=new LinkedMergeSort();
        linkedMergeSort.CreateSinglyLinkedStructure(new Integer[] {5,4,3,2,1});
        linkedMergeSort.mergeSort();


    }
}
