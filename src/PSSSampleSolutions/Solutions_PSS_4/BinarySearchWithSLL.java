package PSSSampleSolutions.Solutions_PSS_4;

import java.util.Random;

public class BinarySearchWithSLL {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }

        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }

    } // class Node

    public static <E> Node<E> findMidNode(Node<E> head, Node<E> tail){
        Node<E> slow = head;
        Node<E> fast = head;

        while (fast != tail){
            fast = fast.getNext();
            if(fast != tail){
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }

        return slow;
    }

    public static Node<Integer> BinarySearch(Node<Integer> head, Node<Integer> tail, int value){
        if ( (head != null && value < head.getElement()) || (tail != null && value > tail.getElement()) )
            return null;

        Node<Integer> midNode = findMidNode(head, tail);

        if (midNode == null)
            return null;
        else if (midNode.getElement() == value)
            return midNode;
        else if (midNode.getElement() > value)
            return BinarySearch(head, midNode, value);
        else
            return BinarySearch(midNode.getNext(), tail, value);
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(0, null);
        Node<Integer> walk = head;

        Random rand = new Random();
        for (int i = 0; i < 9; ++i){
            System.out.print(i * 10 + " ");

            Node<Integer> newest = new Node<>(i * 10, null);
            walk.setNext(newest);
            walk = newest;
        }

        int targetNumber = 654;

        Node<Integer> node = BinarySearch(head, null, targetNumber);
        if (node != null)
            System.out.println("\nnode found");
        else
            System.out.println("\nthere is no node with element equal to " + targetNumber);

    }
}
