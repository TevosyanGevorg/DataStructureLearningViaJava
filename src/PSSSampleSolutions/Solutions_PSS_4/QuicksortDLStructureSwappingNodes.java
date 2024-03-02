package PSSSampleSolutions.Solutions_PSS_4;

import java.util.Random;

public class QuicksortDLStructureSwappingNodes {

    private static class Node<E> {

        /** The element stored at this node */
        private E element;               // reference to the element stored at this node

        /** A reference to the preceding node in the list */
        private Node<E> prev;            // reference to the previous node in the list

        /** A reference to the subsequent node in the list */
        private Node<E> next;            // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e  the element to be stored
         * @param p  reference to a node that should precede the new node
         * @param n  reference to a node that should follow the new node
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        // public accessor methods
        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() { return element; }

        /**
         * Returns the node that precedes this one (or null if no such node).
         * @return the preceding node
         */
        public Node<E> getPrev() { return prev; }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() { return next; }

        // Update methods
        /**
         * Sets the node's previous reference to point to Node n.
         * @param p    the node that should precede this one
         */
        public void setPrev(Node<E> p) { prev = p; }

        /**
         * Sets the node's next reference to point to Node n.
         * @param n    the node that should follow this one
         */
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------

    /**
     * @post-condition  after the execution of the method given head will still refer to the same object.
     * @returns         middle node, when the given head isn't null,
     *                  null otherwise.
     */
    public static <E> Node<E> FindMidNode(Node<E> head){
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

    /**
     * @brief           swaps the given node with its next one, if node isn't null and isn't tail.
     * @pre-condition   node1 and node2 must be inner nodes of doubly linked structure (sentinels are not allowed)
     */
    private static <E> void swap(Node<E> node1, Node<E> node2) {
        if (node1 == null || node2 == null)
            return;

        Node<E> temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);

        node1.getNext().setPrev(node1);
        node2.getNext().setPrev(node2);

        temp = node1.getPrev();
        node1.setPrev(node2.getPrev());
        node2.setPrev(temp);

        node1.getPrev().setNext(node1);
        node2.getPrev().setNext(node2);
    }


    /**
     * @brief   This function takes last element as pivot,
     *          places the pivot element at its correct position
     *          in sorted array, and places all smaller to left
     *          of pivot and all greater elements to right of pivot
     *
     * @param   begin must not be the head sentinel.
     * @param   end must not be the tail sentinel.
     * @returns pivot node.
     */
    private static Node<Integer> partition(Node<Integer> begin, Node<Integer> end) {
        Node<Integer> headSentinel = begin.getPrev();
        Node<Integer> tailSentinel = end.getNext();

        // Choosing the pivot
        int pivot = end.getElement();
        System.out.println("pivot is "  + pivot);

        Node<Integer> lastSmaller = begin.getPrev();

        for (Node<Integer> walk = begin; walk != end; walk = walk.getNext()){
            if (walk.getElement() <= pivot) {
                lastSmaller = (lastSmaller.getElement() == null) ? begin : lastSmaller.getNext();

                Node<Integer> temp1 = lastSmaller.getPrev();
                Node<Integer> temp2 = walk.getNext();
                swap(lastSmaller, walk);

                // recover lastSmaller and walk
                lastSmaller = temp1.getNext();
                walk = temp2.getPrev();

            }
        }

        lastSmaller = (lastSmaller.getElement() == null) ? begin : lastSmaller.getNext();
        Node<Integer> temp1 = lastSmaller.getPrev();
        Node<Integer> temp2 = end.getPrev();
        swap(lastSmaller, end);

        // recover begin, end and lastSmaller
        begin = headSentinel.getNext();
        lastSmaller = temp1.getNext();
        end = tailSentinel.getPrev();

        return lastSmaller;
    }

    /**
     * @pre-condition   The linked structure must have sentinels,
     *                  but firstNode and lastNode must be valid nodes (not sentinel ones).
     */
    public static void quickSort(Node<Integer> firstNode, Node<Integer> lastNode) {
        if (firstNode == lastNode || firstNode.getPrev() == lastNode || lastNode.getElement() == null)
            return;

        Node<Integer> temp1 = firstNode.getPrev();
        Node<Integer> temp2 = lastNode.getNext();
        Node<Integer> pivot = partition(firstNode, lastNode);
        firstNode = temp1.getNext();
        lastNode = temp2.getPrev();

        printDLS(firstNode, lastNode);
        // Separately sort elements before
        // partition and after partition
        quickSort(firstNode, pivot.getPrev());
        printDLS(firstNode, lastNode);
        quickSort(pivot.getNext(), lastNode);
    }

    /**
     * @Brief   Prints doubly linked structure.
     */
    public static void printDLS(Node<Integer> firstSentinel, Node<Integer> lastSentinel) {
        System.out.println();
        for (Node<Integer> walk = firstSentinel; walk != lastSentinel.getNext() && walk != null; walk = walk.getNext())
            System.out.print(walk.getElement() + " ");
    }

    // Driver Code
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(null, null, null);
        Node<Integer> tail = new Node<>(null, head, null);
        head.setNext(tail);

        Node<Integer> walk = head;

//        Node<Integer> newest = new Node<>(14, walk, tail);
//        walk.setNext(newest);
//        tail.setPrev(newest);
//        walk = newest;
//
//        newest = new Node<>(14, walk, tail);
//        walk.setNext(newest);
//        tail.setPrev(newest);
//        walk = newest;
//
//        newest = new Node<>(5, walk, tail);
//        walk.setNext(newest);
//        tail.setPrev(newest);
//        walk = newest;
//
//        newest = new Node<>(6, walk, tail);
//        walk.setNext(newest);
//        tail.setPrev(newest);
//        walk = newest;

        Random rand = new Random();
        for (int i = 0; i < 5; ++i){
            int randomNum = rand.nextInt(19) + 1;

            Node<Integer> newest = new Node<>(randomNum, walk, tail);
            walk.setNext(newest);
            tail.setPrev(newest);
            walk = newest;
        }

        printDLS(head.getNext(), tail.getPrev());

        quickSort(head.getNext(), tail.getPrev());

        System.out.println("Sorted doubly linked structure:");

        printDLS(head, tail);
    }
}
