package LinkedList;

public class SinglyLinkedList<E> {
    //(nested Node class goes here)
    // instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    } // access methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) {
        head = new Node<E>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if(isEmpty())return null;
        E answer = (E) head.getNext();
        size--;
        if (size==0)
            tail=null;
        return  answer;
    }
}
