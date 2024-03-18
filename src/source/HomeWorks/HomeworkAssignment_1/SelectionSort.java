package source.HomeWorks.HomeworkAssignment_1;
import source.DataStructures.LinkedList.DoublyLinkedList.DoublyLinkedList;
import source.DataStructures.LinkedList.DoublyLinkedList.Node;

public class SelectionSort<E> {
    public static DoublyLinkedList Sort(DoublyLinkedList doublyLinkedList){

            Node<Integer> currentNode= doublyLinkedList.header.next;
            Node<Integer> comparerNode=currentNode.next;
            Node<Integer> minimumNode;
            int minValue;

            while (currentNode.getElement()!=null){
                minimumNode=currentNode;
                while (comparerNode.getElement()!=null)
                {
                    //System.out.println(currentNode.getElement()+"<=>"+comparerNode.getElement()+"//[ "+minimumNode.element+" ]");
                    if (comparerNode.getElement()<minimumNode.getElement())
                    {
                        minimumNode=comparerNode;
                    }
                    comparerNode=comparerNode.next;//for Next Iteration
                }
                if(!currentNode.element.equals(minimumNode.element)) {//swap Elements
                    minValue=currentNode.element;
                    currentNode.element=minimumNode.element;
                    minimumNode.element=minValue;
                }
                currentNode=currentNode.next;//for Next Iteration
                comparerNode=currentNode.next;
            }


        return doublyLinkedList;
    }

}
