package HomeWorks.HomeworkAssignment_1;


public class LinkedMergeSort <E> {

    //(a) Copy the Node class from the SinglyLinkedList into this one.
    //(b) Implement a generic method, that given the first node of a singly-linked structure, prints its contents.
    //(c) Implement a generic method that, given an array of generic values, creates a singly-linked structure
//containing the values and returns the first node of the sequence.
    //(d)Implement a generic method that, given the head node of a singly-linked structure L, splits it into two
//singly-linked sequences Lodd and Leven and returns the head nodes of Lodd and Leven
//in a length-2 array. All the elements at odd positions in the original list need to go into Lodd and,
//similarly, all the elements at even positions in the original list need to go into Leven.
//Your method may traverse the original sequence only once. You are not allowed to create any nodes or list objects.
//While we refer to lists L, Lodd and Leven here, the method should not use any list objects; only node sequences.
    protected SinglyLinkedList <E> singlyLinkedList;
    public LinkedMergeSort(){
        this.singlyLinkedList=new SinglyLinkedList<E>();
    }
    public void printFirstNodeElement(){
        this.singlyLinkedList.printFirstNodeElement();
    }
    public SinglyLinkedList.Node CreateSinglyLinkedStructure(E[] array){
        return this.singlyLinkedList.CreateSinglyLinkedStructure(array);
    }
    private class SinglyLinkedList<E> implements Cloneable {
        private class Node<E> {
            private E element;
            private Node<E> next;
            private Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }
            private E getElement() {
                return element;
            }
            private Node<E> getNext() {
                return next;
            }
            private void setNext(Node<E> node) {
                next = node;
            }
        }
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;
        private int size() {
            return size;
        }
        private boolean isEmpty() {
            return size == 0;
        }
        private E first() {
            if (isEmpty()) return null;
            return head.getElement();
        }
        private E last() {
            if (isEmpty()) return null;
            return tail.getElement();
        }
        private void addFirst(E element) {
            head = new Node<>(element, head);
            if (size == 0)
                tail = head;
            size++;
        }
        private void addLast(E element) {
            Node<E> newest = new Node<>(element, null);
            if (isEmpty())
                head = newest;
            else
                tail.setNext(newest);
            tail = newest;
            size++;
        }
        private E removeFirst() {
            if (isEmpty()) return null;
            E answer = head.getElement();
            head = head.getNext();
            size--;
            if (size == 0)
                tail = null;
            return answer;
        }
        private SinglyLinkedList(){}
        private Node<E>CreateSinglyLinkedStructure(E[]array){
            for (int i = 0; i < array.length; i++) {
                addFirst(array[i]);
            }
            return head;
        }
        private void printFirstNodeElement(){
            System.out.print(head.getElement());
        }

    }
}

