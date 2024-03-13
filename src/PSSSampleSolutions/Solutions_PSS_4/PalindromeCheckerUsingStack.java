package PSSSampleSolutions.Solutions_PSS_4;
import ArrayStack;
import source.DataStructures.Stack.Stack;


public class PalindromeCheckerUsingStack {
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


    public static boolean isPalindrome(Node<Character> head){
        Stack<Character> stack = new ArrayStack<>();
        Node<Character> fastHead = head;

        while (fastHead != null){
            stack.push(head.getElement());

            fastHead = fastHead.getNext();

            if (fastHead != null) {
                fastHead = fastHead.getNext();
                head = head.getNext();
            }
        }

        while (!stack.isEmpty()){
            if(head.getElement() != stack.pop())
                return false;

            head = head.getNext();
        }

        return true;
    }

    public static void main(String[] args) {
        String possiblePalindrome = "madam";

        Node<Character> head = new Node<>(possiblePalindrome.charAt(0), null);
        Node<Character> walk = head;

        for (int i = 1; i < possiblePalindrome.length(); ++i){
            Node<Character> newest = new Node<>(possiblePalindrome.charAt(i), null);
            walk.setNext(newest);
            walk = newest;
        }

        System.out.println(isPalindrome(head));
    }
}
