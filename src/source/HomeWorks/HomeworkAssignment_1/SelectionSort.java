package source.HomeWorks.HomeworkAssignment_1;

public class SelectionSort<E> {
    public static DoublyLinkedList Sort(DoublyLinkedList doublyLinkedList){

            DoublyLinkedList.Node<Integer> currentNode= doublyLinkedList.header.next;
            DoublyLinkedList.Node<Integer> comparerNode=currentNode.next;
            DoublyLinkedList.Node<Integer> minimumNode;
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

    public static class DoublyLinkedList<E> {
        public Node<E> header;
        public Node<E> trailer;
        public int size = 0;
        public DoublyLinkedList( ) {
            header = new Node<>(null, null, null);
            trailer = new Node<>(null, header, null);
            header.setNext(trailer);
        }
        public boolean isEmpty() { return size == 0; }
        public E first( ) {
            if (isEmpty()) return null;
            return header.getNext().getElement();
        }
        public E last( ) {
            if (isEmpty()) return null;
            return trailer.getPrev().getElement();
        }
        public void addFirst(E e) {
            addBetween(e, header, header.getNext());
        }
        public void addLast(E e) {
            addBetween(e, trailer.getPrev(), trailer);
        }
        public E removeFirst( ) {
            if (isEmpty()) return null; // nothing to remove
            return remove(header.getNext()); // first element is beyond header
        }
        public E removeLast( ) {
        if (isEmpty()) return null;
            return remove(trailer.getPrev());
        }
        public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
            // create and link a new node
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.setNext(newest);
            successor.setPrev(newest);
            size++;
        }
        public E remove(Node<E> node) {
            Node<E> predecessor = node.getPrev( );
            Node<E> successor = node.getNext( );
            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
            return node.getElement( );
        }
        public Node<E> CreateLinkedStructure(E[]array){
            for (int i = 0; i < array.length; i++) {
                addLast(array[i]);
            }
            return header;
        }
        public void PrintFirstNodeElement(){
            Node<E> current=this.header.next;
            while (current!=trailer){
                System.out.print("[");
                System.out.print(current.getElement());
                System.out.print("]");
                current=current.next;
            }
            System.out.println();

        }

        public static class Node<E> {
            public E element;
            public Node<E> prev;
            public Node<E> next;

            public Node(E e, Node<E> p, Node<E> n) {
                element = e;
                prev = p;
                next = n;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getPrev() {
                return prev;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setPrev(Node<E> p) {
                prev = p;
            }

            public void setNext(Node<E> n) {
                next = n;
            }
        }
    }
}
