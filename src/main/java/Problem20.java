import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch == ')' || ch == ']' || ch == '}') && stack.isEmpty()) return false;
            else if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') stack.pop();
            else if (!stack.isEmpty() && stack.peek() == '{' && ch == '}') stack.pop();
            else if (!stack.isEmpty() && stack.peek() == '[' && ch == ']') stack.pop();
            else if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else if (!stack.isEmpty() && stack.peek() != '(' && ch == ')') return false;
            else if (!stack.isEmpty() && stack.peek() != '{' && ch == '}') return false;
            else if (!stack.isEmpty() && stack.peek() != '[' && ch == ']') return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.isValid("()"));
        System.out.println(problem20.isValid("()[]{}"));
        System.out.println(problem20.isValid("(]"));
        System.out.println(problem20.isValid("([)]"));
        System.out.println(problem20.isValid("{[]}"));
    }
}
