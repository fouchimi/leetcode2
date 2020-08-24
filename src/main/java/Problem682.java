import java.util.Stack;

public class Problem682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            char ch = op.charAt(0);
            if (ch == 'D') {
                sum += 2 * stack.peek();
                stack.push(2 * stack.peek());
            } else if (ch == 'C') {
                sum -= stack.pop();
            } else if (ch == '+'){
                int top = stack.pop();
                int tempSum = top + stack.peek();
                sum += tempSum;
                stack.push(top);
                stack.push(tempSum);
            } else {
                int val = Integer.parseInt(op);
                sum += val;
                stack.push(val);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem682 problem682 = new Problem682();
        //System.out.println(problem682.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(problem682.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
