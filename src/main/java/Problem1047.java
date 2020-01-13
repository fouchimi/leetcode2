import java.util.Stack;

public class Problem1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.isEmpty()) stack.push(ch);
            else if (stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1047 problem1047 = new Problem1047();
        System.out.println(problem1047.removeDuplicates("abbaca"));
    }
}
