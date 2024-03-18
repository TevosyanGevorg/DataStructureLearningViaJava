package source.PSSSampleSolutions.solutions_PSS_5;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.ArrayQueue;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.Queue;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.Stack;

public class StackQueue<E> implements Stack<E> {

    private Queue<E> queue1 = new ArrayQueue<>();
    private Queue<E> queue2 = new ArrayQueue<>();


    // Queue 1:

    // Queue 2:

    @Override
    public int size() {
        return queue1.size();
    }

    @Override
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    @Override
    public void push(E e) {
        while (!queue1.isEmpty())
            queue2.enqueue(queue1.dequeue());

        queue1.enqueue(e);

        while (!queue2.isEmpty())
            queue1.enqueue(queue2.dequeue());
    }

    @Override
    public E top() {
        return queue1.first();
    }

    @Override
    public E pop() {
        return queue1.dequeue();
    }
}
