package PSSSampleSolutions.solutions_PSS_5;

import PSSSampleSolutions.solutions_PSS_5.stackqueue.Stack;

public class Problem2 {

    public static void main(String[] args) {

    }


    public static void removeMoldy(Stack<String>[] cans) {
        String[] colors = {"Black", "Blue", "Red", "Yellow", "Green"};

        for (int i = 0; i < cans.length; i++) {
            int k = 0;
            while (!cans[i].isEmpty() && cans[i].top() != "Moldy") {
                if (k >= cans.length)
                    cans[i].pop();
                else if (k == i || cans[k].size() == 20)
                    k++;
                else
                    cans[k].push(cans[i].pop());
            }

            cans[i].pop(); // Moldy

            for (int j = 0; j < cans.length && j != i; j++) {
                while (cans[j].top() == colors[i])
                    cans[i].push(cans[j].pop());
            }
        }
    }
}
