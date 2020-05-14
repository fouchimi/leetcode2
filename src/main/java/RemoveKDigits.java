import java.util.*;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k || num.length() < k) return "0";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (k > 0 && i < num.length()) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while (i < num.length()) {
            stack.push(num.charAt(i));
            i++;
        }

        // This is when the number given is sorted in descending order
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.firstElement() == '0') stack.remove(0);
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
//        System.out.println(removeKDigits.removeKdigits("1432219", 3));
        System.out.println(removeKDigits.removeKdigits("10200", 1));
    }
}
