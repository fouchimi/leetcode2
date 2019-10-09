import java.util.LinkedList;
import java.util.Queue;

public class Problem559 {

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node top = queue.poll();
                if(top == null) return level+1;
                for(int j = 0; j < top.children.size(); j++) {
                    if (top.children.get(j) != null) queue.offer(top.children.get(j));
                }
            }
            level++;
        }
        return level+1;
    }
}
