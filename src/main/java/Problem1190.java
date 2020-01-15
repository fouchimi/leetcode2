import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || Character.isLetter(ch)) stack.push(ch);
            else {
                List<Character> list = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') list.add(stack.pop());
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                while (!list.isEmpty()) stack.push(list.remove(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1190 problem1190 = new Problem1190();
        System.out.println(problem1190.reverseParentheses("(abcd)"));
        System.out.println(problem1190.reverseParentheses("(u(love)i)"));
        System.out.println(problem1190.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(problem1190.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
