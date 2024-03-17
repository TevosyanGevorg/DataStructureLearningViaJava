import HomeWorks.HomeworkAssignment_1.LinkedMergeSort;
import HomeWorks.HomeworkAssignment_1.SelectionSort;
import source.DataStructures.LinkedList.DoublyLinkedList.DoublyLinkedList;


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


//        LinkedMergeSort.SinglyLinkedList singlyLinkedList=new LinkedMergeSort.SinglyLinkedList();
//        LinkedMergeSort.SinglyLinkedList.Node head = singlyLinkedList.CreateSinglyLinkedStructure(new Integer[] {5,4,3,2,1});
//        singlyLinkedList.PrintFirstNodeElement();
//        LinkedMergeSort.SinglyLinkedList.Node[] headsOfEvenAndOdd = singlyLinkedList.SplitToEvenAndOdd(head);
//        head=singlyLinkedList.MergeEvenAndOdd(headsOfEvenAndOdd);
//        singlyLinkedList.PrintFirstNodeElement();

//        LinkedMergeSort.SinglyLinkedList singlyLinkedList=new LinkedMergeSort.SinglyLinkedList();
//        singlyLinkedList.CreateSinglyLinkedStructure(new Integer[] {5,12,6,10,8,9,1,2,13,7,3,4,11});
//        singlyLinkedList.PrintFirstNodeElement();
//        singlyLinkedList=singlyLinkedList.MergeSort(singlyLinkedList);
//        singlyLinkedList.PrintFirstNodeElement();

        DoublyLinkedList doublyLinkedList=new DoublyLinkedList();
        //doublyLinkedList.CreateLinkedStructure(new Integer[] {5,12,6,10,8,9,1,2,13,7,3,4,11});
        doublyLinkedList.CreateLinkedStructure(new Integer[] {5,12,6,10,8,9,1,2,13,7,3,4,11});
        doublyLinkedList.PrintFirstNodeElement();
        SelectionSort.Sort(doublyLinkedList);
        doublyLinkedList.PrintFirstNodeElement();

    }
}
