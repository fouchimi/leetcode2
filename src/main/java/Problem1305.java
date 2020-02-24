import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dfs(root1, pq);
        dfs(root2, pq);
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll());
        return res;
    }

    private void dfs(TreeNode x, PriorityQueue<Integer> pq) {
        if (x == null) return;
        dfs(x.left, pq);
        pq.offer(x.val);
        dfs(x.right, pq);
    }

    private void print(List<Integer> list) {
        for (Integer val : list) System.out.print(val + " ");
    }

    public static void main(String[] args) {
        Problem1305 problem1305 = new Problem1305();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        problem1305.print(problem1305.getAllElements(root1, root2));

    }
}
