package source.HomeWorks.HomeworkAssignment_1;

public class StackSort {
    // Write a program that sorts a Stack of unique Integers using in-place Selection Sort.
    // The largest element should be at the top, and the smallest should be at the bottom of the stack.
    // You are not allowed to use any additional containers or create any new objects.
    // Your program may include additional helper methods.
    // You are NOT allowed to use java.util.Stack functionality.
    // Note that you don’t need to swap elements.



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
    public class SinglyLinkedList<E>{
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
            head = new Node<E>(element, head);
            if (size == 0)
                tail = head;
            size++;
        }
        public void addLast(E element) {
            Node<E> newest = new Node<E>(element, null);
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
    }
    public class LinkedStack<E> implements Stack<E> {
        SinglyLinkedList<E> list= new SinglyLinkedList<E>();
        public LinkedStack(){}
        @Override
        public int size() {
            return list.size();
        }
        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }
        @Override
        public void push(E element) {
            list.addFirst(element);
        }
        @Override
        public E top() {
            return list.first();
        }
        @Override
        public E pop() {
            return list.removeFirst();
        }

    }
    public static void sortarray(int[ ] data) {
        for (int k = 0; k < data.length - 1; k++) {
            int minIndex = k;
            for(int j=k+1;j<data.length;j++)
            {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[k];
            data[k] = data[minIndex];
            data[minIndex] = temp;
        }
    }
    public static void sortStack(LinkedStack stack) {
        int size = stackSize(stack);
        for (int i = 0; i < size - 1; i++) {
            int minIndex = findMinIndex(stack, size - i);
            insertMinToBottom(stack, minIndex);
        }
    }

    public static int stackSize(LinkedStack<Node> stack) {
        int size = 0;
        Node current = stack.top();
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public static int findMinIndex(LinkedStack<Node> linkedStack, int stackSize) {
        LinkedStack<Node> tempLinkedStack=null;
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < stackSize; i++) {
            int value = (Integer) linkedStack.pop().getElement();
            if (value < minValue) {
                minIndex = i;
                minValue = value;
            }
            tempLinkedStack.push(linkedStack.pop());
        }

        while (!tempLinkedStack.isEmpty()) {
            linkedStack.push(tempLinkedStack.pop());
        }

        return minIndex;
    }

    public static void insertMinToBottom(LinkedStack linkedStack, int minIndex) {
        LinkedStack tempLinkedStack =null;

        int size = stackSize(tempLinkedStack);
        for (int i = 0; i < size; i++) {
            int value = (Integer)tempLinkedStack.pop();
            if (i != minIndex) {
                tempLinkedStack.push(value);
            }
        }

        while (!tempLinkedStack.isEmpty()) {
            linkedStack.push(tempLinkedStack.pop());
        }

        linkedStack.push(minIndex);
    }

    public static void printStack(Stack stack) {
        Stack tempStack = null;
        while (!stack.isEmpty()) {
            int data = (Integer) stack.pop();
            System.out.print(data + " ");
            tempStack.push(data);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        System.out.println();
    }



}
