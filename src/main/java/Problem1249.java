import java.util.Stack;

public class Problem1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indexStack = new Stack<>();
        boolean[] valid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                indexStack.push(i);
                valid[i] = true;
            }
            else if (ch == ')') {
                if (indexStack.isEmpty()) valid[i] = false;
                else {
                    indexStack.pop();
                    valid[i] = true;
                }
            } else valid[i] = true;
        }

        while (!indexStack.isEmpty()) valid[indexStack.pop()] = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (valid[i]) sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1249 problem1249 = new Problem1249();
        System.out.println(problem1249.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(problem1249.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(problem1249.minRemoveToMakeValid("))(("));
        System.out.println(problem1249.minRemoveToMakeValid("(a(b(c)d)"));
    }
}
