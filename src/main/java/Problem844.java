import java.util.Stack;

public class Problem844 {
    public boolean backspaceCompare(String S, String T) {

        Stack<Character> stack1 = process(S);
        Stack<Character> stack2 = process(T);

        if (stack1.size() != stack2.size()) return false;

        while ((!stack1.isEmpty() && !stack2.isEmpty()) && (stack1.peek() == stack2.peek())) {
            stack1.pop();
            stack2.pop();
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    private Stack<Character> process(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty() && ch == '#') continue;
            else if (!stack.isEmpty() && ch == '#') stack.pop();
            else stack.push(ch);
        }
        return stack;
    }

    public static void main(String[] args) {
        Problem844 problem844 = new Problem844();
        System.out.println(problem844.backspaceCompare("ab#c", "ad#c"));
    }
}
