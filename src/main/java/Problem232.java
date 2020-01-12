import java.util.Stack;

public class Problem232 {

    Stack<Integer> stack;

    public Problem232() {
        stack= new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int peek() {
        if (empty()) throw new IllegalStateException();
        Stack<Integer> temp = new Stack<>();
        while (!empty()) temp.push(stack.pop());
        int top = temp.peek();
        while (!temp.isEmpty()) stack.push(temp.pop());
        return top;
    }

    public int pop() {
        if (empty()) throw new IllegalStateException();
        Stack<Integer> temp = new Stack<>();
        while (!empty()) temp.push(stack.pop());
        int top = temp.pop();
        while (!temp.isEmpty()) stack.push(temp.pop());
        return top;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem232 problem232 = new Problem232();
    }
}
