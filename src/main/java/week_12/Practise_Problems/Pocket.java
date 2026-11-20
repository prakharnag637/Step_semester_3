
import java.util.*;

public class pocket {

    // Method 1: Convert Infix to Postfix
    static String toPostfix(String infix) {

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            // If operand, add directly to postfix
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            }

            // If opening bracket, push into stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If closing bracket, pop until '('
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid expression");
                }

                stack.pop();
            }

            // If operator
            else {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    postfix.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {

            char ch = stack.pop();

            if (ch == '(') {
                throw new IllegalArgumentException("Invalid expression");
            }

            postfix.append(ch);
        }

        return postfix.toString();
    }

    // Return operator precedence
    static int precedence(char op) {

        if (op == '+' || op == '-') {
            return 1;
        }

        if (op == '*' || op == '/') {
            return 2;
        }

        return 0;
    }

    // Method 2: Evaluate Postfix
    static int evaluate(String postfix) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {

            char ch = postfix.charAt(i);

            // If operand, push into stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }

            // If operator, perform calculation
            else {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (ch) {

                    case '+':
                        result = a + b;
                        break;

                    case '-':
                        result = a - b;
                        break;

                    case '*':
                        result = a * b;
                        break;

                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = a / b;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String infix = sc.nextLine().trim();

            if (infix.isEmpty()) {
                continue;
            }

            String postfix = toPostfix(infix);

            int result = evaluate(postfix);

            System.out.println(postfix + " = " + result);
        }

        sc.close();
    }
}
