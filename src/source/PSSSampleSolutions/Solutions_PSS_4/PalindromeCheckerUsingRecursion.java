package source.PSSSampleSolutions.Solutions_PSS_4;

public class PalindromeCheckerUsingRecursion {
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

    private static boolean isPalindromeImpl(Node<Character> right){
        if (right == null)
            return true;

        boolean isOK = isPalindromeImpl(right.getNext());
        if(!isOK)
            return false;

        isOK = left.getElement() == right.getElement();
        left = left.getNext();

        return isOK;
    }

    private static Node<Character> left;

    public static boolean isPalindrome(Node<Character> head){
        left = head;
        boolean isListPalindrome = isPalindromeImpl(head);
        left = null;
        return isListPalindrome;
    }

    public static void main(String[] args) {
        String possiblePalindrome = "aa";

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
