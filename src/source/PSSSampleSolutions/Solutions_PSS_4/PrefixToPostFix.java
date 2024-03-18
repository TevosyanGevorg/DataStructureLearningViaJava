package source.PSSSampleSolutions.Solutions_PSS_4;
import source.DataStructures.Stack.ArrayStack;
import source.DataStructures.Stack.Stack;

public class PrefixToPostFix {

    private static boolean isOperator(char c){
        switch(c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    public static String convert(String prefixExpr){
        Stack<String> stack = new ArrayStack();
        for (int i = prefixExpr.length() - 1; i >= 0; --i){
            char currentChar = prefixExpr.charAt(i);

            if (isOperator(currentChar)){
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                stack.push(operand1 + operand2 + currentChar);
            }
            else
                stack.push(String.valueOf(currentChar));
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        System.out.println(convert("*-A/BC-/AKL"));
    }
}
