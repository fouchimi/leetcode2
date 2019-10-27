import java.util.Stack;

public class Problem394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        StringBuilder sb;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ']') {
                sb = new StringBuilder();
                while (!stack.isEmpty())  {
                    char topChar = stack.peek().charAt(0);
                    if (topChar == '[') {
                        stack.pop();
                        stack.push(sb.toString());
                        sb = new StringBuilder();
                    }
                    else if (Character.isDigit(topChar)) {
                        StringBuilder mulStr = new StringBuilder();
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) mulStr.insert(0, stack.pop());
                        int mul = Integer.parseInt(mulStr.toString());
                        sb = helper(sb.toString(), mul);
                        stack.push(sb.toString());
                        break;
                    } else sb.insert(0, stack.pop());
                }
            } else stack.push(String.valueOf(ch));
            i++;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.insert(0, stack.pop());
        return res.toString();
    }

    private StringBuilder helper(String str, int mul) {
        StringBuilder tempAns = new StringBuilder();
        while (mul > 0) {
            tempAns.append(str);
            mul--;
        }
        return tempAns;
    }

    public  static void main(String[] args) {
        Problem394 problem394 = new Problem394();
        System.out.println(problem394.decodeString("3[a]2[bc]"));
        System.out.println(problem394.decodeString("3[a2[c]]"));
        System.out.println(problem394.decodeString("2[abc]3[cd]ef"));
        System.out.println(problem394.decodeString("100[leetcode]"));
    }
}
