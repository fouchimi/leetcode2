import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Map<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            int start = i;
            while (i < s.length() && s.charAt(start) == s.charAt(i)) i++;
            int value = i - start;
            if (stack.isEmpty()) {
                Map<Character, Integer> map = new HashMap<>();
                map.put(s.charAt(start), value % k);
                stack.push(map);
            } else {
                Map<Character, Integer> peek = stack.peek();
                if (peek.containsKey(s.charAt(start))) {
                    peek.put(s.charAt(start), (value + peek.get(s.charAt(start))) % k);
                } else {
                    Map<Character, Integer> map = new HashMap<>();
                    map.put(s.charAt(start), value % k);
                    stack.push(map);
                }
            }

            while (!stack.isEmpty() && stack.peek().containsValue(0)) stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Map<Character, Integer> currentMap = stack.peek();
            StringBuilder tmpSb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : currentMap.entrySet()) {
                int value = entry.getValue();
                while (value > 0) {
                    tmpSb.append(entry.getKey());
                    value--;
                }
            }
            sb.insert(0, tmpSb.toString());
            stack.pop();
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        Problem1209 problem1209 = new Problem1209();
//        System.out.println(problem1209.removeDuplicates("abcd", 2));
        System.out.println(problem1209.removeDuplicates("deeedbbcccbdaa", 3));
    }

}
