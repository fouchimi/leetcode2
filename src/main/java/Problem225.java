import java.util.LinkedList;
import java.util.List;

public class Problem225 {

    List<Integer> queue;
    public Problem225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (empty()) throw new IllegalStateException();
        return queue.remove(queue.size() - 1);
    }

    public int top() {
        if (empty()) throw new IllegalStateException();
        return queue.get(queue.size() - 1);
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Problem225 problem225 = new Problem225();
        problem225.push(1);
        problem225.push(2);
        System.out.println(problem225.top());
        System.out.println(problem225.pop());
        System.out.println(problem225.empty());
    }
}
