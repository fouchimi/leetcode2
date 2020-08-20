import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Problem385 {
//    public NestedInteger deserialize(String s) {
//        Stack<NestedInteger> stack = new Stack<>();
//        int sign = 1;
//        for (int i = 0; i < s.length(); ) {
//            char ch = s.charAt(i);
//            if (ch == '-') {
//                sign = -1;
//                i++;
//            }
//            else if (Character.isDigit(ch)) {
//                int j = i;
//                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
//                Integer value = sign * Integer.parseInt(s.substring(i, j));
//                if (stack.isEmpty()) stack.push(new NestedInteger(value));
//                else {
//                    NestedInteger top = stack.pop();
//                    top.add(new NestedInteger(value));
//                    stack.push(top);
//                }
//                i = j;
//                sign = 1;
//            } else if (ch == '[') {
//                NestedInteger emptyList = new NestedInteger();
//                stack.push(emptyList);
//                i++;
//            } else if (ch == ']') {
//                NestedInteger topList = stack.pop();
//                if (!stack.isEmpty()) stack.peek().add(topList);
//                else stack.push(topList);
//                i++;
//            } else i++;
//        }
//        return stack.pop();
//    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }

}
