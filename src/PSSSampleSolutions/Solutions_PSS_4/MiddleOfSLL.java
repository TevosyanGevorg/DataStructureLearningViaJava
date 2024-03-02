package PSSSampleSolutions.Solutions_PSS_4;

import java.util.Random;

public class MiddleOfSLL {

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

    /**
     * @post-condition  after the execution of the method given head will still refer to the same object.
     * @returns         middle node, when the given head isn't null,
     *                  null otherwise.
     */
    public static <E> Node<E> findMidNode(Node<E> head){
        Node<E> slow = head;
        Node<E> fast = head;

        while (fast != null){
            fast = fast.getNext();
            if(fast != null){
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(0, null);
        Node<Integer> walk = head;

        Random rand = new Random();
        for (int i = 0; i < 9; ++i){
            int randomNum = rand.nextInt(19) + 1;
            System.out.print(randomNum + " ");

            Node<Integer> newest = new Node<>(randomNum, null);
            walk.setNext(newest);
            walk = newest;
        }
        System.out.println();
        System.out.println(findMidNode(head).getElement());

    }
}
