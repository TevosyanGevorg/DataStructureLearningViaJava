import source.LinkedList.SinglyLinkedList.SinglyLinkedList;

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

        SinglyLinkedList<Integer> singlyLinkedList=new SinglyLinkedList<Integer>();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);


        SinglyLinkedList<Integer> singlyLinkedList2=new SinglyLinkedList<Integer>();
        singlyLinkedList2=singlyLinkedList.clone();
        boolean isEqual= singlyLinkedList2.equals(singlyLinkedList);
        singlyLinkedList.first();
        singlyLinkedList2=singlyLinkedList;

        isEqual= singlyLinkedList2.equals(singlyLinkedList);

        singlyLinkedList.removeFirst();
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeFirst();


    }
}
