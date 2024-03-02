package PSSSampleSolutions.solutions_PSS_5;

import PSSSampleSolutions.solutions_PSS_5.stackqueue.Queue;

public class Problem3 {

    public static void main(String[] args) {


    }




    public static void sortedEnqueue(Queue<Integer> queue, int num) {
        int size = queue.size();

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (queue.first() < num)
                queue.enqueue(queue.dequeue());
            else {
                if (!found) {
                    queue.enqueue(num);
                    found = true;
                }
                queue.enqueue(queue.dequeue());
            }
        }
    }
}
