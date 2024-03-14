package HomeWorks.HomeworkAssignment_1;


public class LinkedMergeSort <E> {
    protected SinglyLinkedList <E> singlyLinkedList;
    public LinkedMergeSort(){
        this.singlyLinkedList=new SinglyLinkedList<E>();
    }

    public static class SinglyLinkedList<E> implements Cloneable {
        public class Node<E> {
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
        public Node<E> head = null;
        public Node<E> tail = null;
        public int size = 0;
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
        public void addFirst(E element) {
            head = new Node<>(element, head);
            if (size == 0)
                tail = head;
            size++;
        }
        public void addLast(E element) {
            Node<E> newest = new Node<>(element, null);
            if (isEmpty())
                head = newest;
            else
                tail.setNext(newest);
            tail = newest;
            size++;
        }
        public E removeFirst() {
            if (isEmpty()) return null;
            E answer = head.getElement();
            head = head.getNext();
            size--;
            if (size == 0)
                tail = null;
            return answer;
        }
        public SinglyLinkedList(){}


        public Node<E>CreateSinglyLinkedStructure(E[]array){
            for (int i = 0; i < array.length; i++) {
                addLast(array[i]);
            }
            return head;
        }
        public void PrintFirstNodeElement(){
            Node<E>current=this.head;
            while (current!=null){
                System.out.print(current.getElement());
                current=current.next;
            }
            System.out.println();

        }
        public SinglyLinkedList.Node[] SplitToEvenAndOdd(SinglyLinkedList.Node head) {
            SinglyLinkedList<E> Leven=new SinglyLinkedList<E>();
            SinglyLinkedList<E> Lodd=new SinglyLinkedList<E>();
            Node <E> L=head;
            int possition=1;
            while(L!=null){
                if (possition%2 == 0) {
                    Leven.addFirst(L.getElement());
                }
                else Lodd.addFirst(L.getElement());
                L=L.next;
                possition++;
            }
            return new Node[]{Lodd.head,Leven.head};
        }
        public Node MergeEvenAndOdd(Node<E>[] heads) {
            SinglyLinkedList<E> merged=new SinglyLinkedList<E>();

            int possition=1;
            while(!(heads[0]==null&&heads[1]==null)){
                if (possition%2 == 0) {
                    merged.addLast(heads[1].getElement());
                    heads[1]=heads[1].getNext();
                }
                else {
                    merged.addLast(heads[0].getElement());
                    heads[0]=heads[0].getNext();
                }
                possition++;
            }
            return merged.head;
        }


        //(f) Implement a generic method that,
        // given the head node of a singly-linked structure of integer elements
        // applies merge sort on it and returns the head node of the resulting sequence.
        //(g) Add a main method, and test all the methods above.
        public SinglyLinkedList<E> Merge(SinglyLinkedList<E>[] lists) {
            SinglyLinkedList<E> merged=new SinglyLinkedList<E>();
            int positionLeft=lists[0].size;
            int positionRight=lists[1].size;
            Node<E> Left=lists[0].head;
            Node<E> Right=lists[1].head;


            while(Left!=null&&Right!=null){
                if (Left.getElement()!=null&&Right.getElement()!=null) {
                    if ((Integer) Left.getElement() < (Integer) Right.getElement()) {
                        merged.addLast(Left.getElement());
                        Left = Left.getNext();
                    } else {
                        merged.addLast(Right.getElement());
                        Right = Right.getNext();
                    }
                }
            }

            while(Left!=null){
                merged.addLast(Left.getElement());
                Left = Left.getNext();
            }
            while(Right!=null){
                merged.addLast(Right.getElement());
                Right = Right.getNext();
            }

            return merged;
        }

        public SinglyLinkedList[] Split(Node<E> head){
            SinglyLinkedList<E> Leven=new SinglyLinkedList<E>();
            SinglyLinkedList<E> Lodd=new SinglyLinkedList<E>();
            Node <E> L=head;
            int possition=1;
            while(L!=null){
                if (possition%2 == 0) {
                    Leven.addFirst(L.getElement());
                }
                else Lodd.addFirst(L.getElement());
                L=L.next;
                possition++;
            }
            return new SinglyLinkedList[]{Lodd,Leven};
        }
        public SinglyLinkedList<E>  MergeSort (SinglyLinkedList<E> singlyLinkedList){
            //singlyLinkedList.PrintFirstNodeElement();
            if (singlyLinkedList.head.next == null) {
                return singlyLinkedList;
            }
            SinglyLinkedList<E>[] lists=Split(singlyLinkedList.head);
            lists[0]=MergeSort(lists[0]);
            lists[1]=MergeSort(lists[1]);
            //singlyLinkedList.PrintFirstNodeElement();

            singlyLinkedList=Merge(lists);


            return singlyLinkedList;





//            if (!(headsOfEvenAndOdd [0]== null&&headsOfEvenAndOdd [1]== null)) {
//                head=MergeRecursively(headsOfEvenAndOdd);
//            }
//            else if (headsOfEvenAndOdd[0].next== null&&headsOfEvenAndOdd[1].next==null) {
//                head=MergeRecursively(headsOfEvenAndOdd);
//            }
//            else{
//                Merge(headsOfEvenAndOdd[0]);
//                Merge(headsOfEvenAndOdd[1]);
//            }

            //headsOfEvenAndOdd=singlyLinkedList.SplitRecursively(headsOfEvenAndOdd[0]);
            //headsOfEvenAndOdd=singlyLinkedList.SplitRecursively(headsOfEvenAndOdd[1]);
            //singlyLinkedList.PrintFirstNodeElement();
        }
    }
}

