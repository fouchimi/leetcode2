import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem116 {

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Node> list = new ArrayList<>();
            for(int i = 0; i < level; i++) {
                Node top = queue.poll();
                if(top == null) continue;
                if(top.left != null) {
                    list.add(top.left);
                    queue.offer(top.left);
                }
                if(top.right != null) {
                    list.add(top.right);
                    queue.offer(top.right);
                }
            }
            for(int i = 1; i < list.size(); i++) {
                list.get(i-1).next = list.get(i);
            }
        }
        return root;
    }

    private void dfs(Node root) {
        if(root == null) return;
        System.out.print(root.val + ", ");
        if(root.next != null) System.out.print("next: " + root.next.val + ", ");
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        Problem116 problem116 = new Problem116();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node x = problem116.connect(root);
        problem116.dfs(x);
    }
}
