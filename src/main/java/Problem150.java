import java.util.Stack;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                switch (token) {
                    case "+":
                        int add = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(add));
                        break;
                    case "-":
                        String first = stack.pop(), second = stack.pop();
                        int subtract = Integer.parseInt(second) - Integer.parseInt(first);
                        stack.push(String.valueOf(subtract));
                        break;
                    case "*":
                        int multiply = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(multiply));
                        break;
                    default:
                        String divisor = stack.pop(), dividend = stack.pop();
                        int divide = Integer.parseInt(dividend) / Integer.parseInt(divisor);
                        stack.push(String.valueOf(divide));
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
    }

    public static void main(String[] args) {
        Problem150 problem150 = new Problem150();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(problem150.evalRPN(tokens));
        System.out.println(problem150.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
