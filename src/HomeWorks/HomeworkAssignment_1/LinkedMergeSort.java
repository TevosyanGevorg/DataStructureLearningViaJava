package HomeWorks.HomeworkAssignment_1;


public class LinkedMergeSort <E> {
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
    public void mergeSort(){
        singlyLinkedList.mergeSort();
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

        private void mergeSort() {
            Node[] LoddAndLeven=SplitToEvenAndOdd(head);


        }
        private Node<E>[] SplitToEvenAndOdd(Node<E> head) {
            Node<E> Leven=new Node<E>(null,null)
                    ,Lodd=new Node<E>(null,null)
                    ,L=head;
            while(L!=null){
                if ((Integer) L.getElement()%2 == 0) {
                    Leven=new Node<>(L.getElement(),Leven);
                }
                else Lodd=new Node<>(L.getElement(),Lodd);
                L=L.next;
            }
            return new Node[]{Lodd,Leven};
        }
    }
}

