package source.PSSSampleSolutions.solutions_PSS_5;

import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.ArrayQueue;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.ArrayStack;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.Queue;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.Stack;

public class Problem5 {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);


        queueStack(stack, queue, false);

        while (!stack.isEmpty())
            System.out.println(stack.pop());

        System.out.println();

        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }

    public static void queueStack(Stack<Integer> stack, Queue<Integer> queue, boolean queueDone) {
        if (stack.isEmpty())
            return;

        int queueSize = queue.size();
        if (!queueDone) {
            for (int i = 0; i < queueSize; i++) {
                int answer = queue.dequeue();
                if (answer % 2 == 0)
                    stack.push(answer);
                else
                    queue.enqueue(answer);
            }
        }
        int answer = stack.pop();
        queueStack(stack, queue, true);
        if (answer % 2 != 0)
            queue.enqueue(answer);
        else
            stack.push(answer);
    }

}
