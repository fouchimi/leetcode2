import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem155 {
    Stack<Integer> stack;
    int min;
    public Problem155() {
        stack = new Stack<>();
        min = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
            return;
        }
        min = Math.min(min, x);
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) throw new IllegalStateException("minStack is empty");
        if (top() == min) min = Integer.MAX_VALUE;
        stack.pop();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            min = Math.min(min, top);
            list.add(0, top);
        }
        while (!list.isEmpty()) stack.push(list.remove(0));
    }

    public int top() {
        if (stack.isEmpty()) throw new IllegalStateException("minStack is empty");
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) throw new IllegalStateException("minStack is Empty");
        return min;
    }

    public static void main(String[] args) {
        Problem155 problem155 = new Problem155();
        problem155.push(-2);
        problem155.push(0);
        problem155.push(-3);
        System.out.println(problem155.getMin());
        problem155.pop();
        System.out.println(problem155.top());
        System.out.println(problem155.getMin());
    }
}
