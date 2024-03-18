package source.PSSSampleSolutions.solutions_PSS_5;

import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.ArrayStack;
import source.PSSSampleSolutions.solutions_PSS_5.stackqueue.Stack;

import java.util.Objects;

public class Problem1 {
    public static void main(String[] args) {


    }

    public static void sortColors(Stack<String> stack) {
        if (!stack.isEmpty()) {
            String result = stack.pop();
            sortColors(stack);
            insertColorSorted(stack, result);
        }
    }

    public static void insertColorSorted(Stack<String> stack, String color) {
        if (stack.isEmpty() || getPriorityColor(color) >= getPriorityColor(stack.top()))
            stack.push(color);
        else {
            String result = stack.pop();
            insertColorSorted(stack, color);
            stack.push(result);
        }

    }
    private static int getPriorityColor(String color) {
        if (Objects.equals(color, "red"))
            return 1;
        if (Objects.equals(color, "green"))
            return 2;
        if (Objects.equals(color, "blue"))
            return 3;
        return 0;
    }
}
