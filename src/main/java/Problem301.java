import java.util.*;

public class Problem301 {

    List<String> results;
    Set<String> set;

    public List<String> removeInvalidParentheses(String s) {
        if (s.length() == 0) return Arrays.asList("");

        results = new ArrayList<>();
        set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);

        int foundLength = 0;
        while (!q.isEmpty()) {
            String input = q.poll();

            if (input.length() < foundLength) break;

            if (set.contains(input)) continue;

            set.add(input);
            if (isValid(input)) {
                results.add(input);
                foundLength = input.length();
            } else { /* if we find what we need we stop checking for smaller lengths */
                if (input.length() - 1 >= foundLength) {
                    for (int i = 0; i < input.length(); i++) {
                        q.add(input.substring(0,i) + input.substring(i+1));
                    }
                }
            }
        }

        return results;
    }

    /**
     Complexity O(n)
     */
    private boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem301 problem301 = new Problem301();
        List<String> list = problem301.removeInvalidParentheses("()())()");
        for(String parenthese : list) {
            System.out.print(parenthese + " ");
        }
    }
}
