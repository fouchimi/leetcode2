import java.util.LinkedList;
import java.util.Queue;

public class Problem1261 {
    private TreeNode root;
    public  Problem1261(TreeNode root) {
        if (root == null) return;
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                top.left.val = 2*top.val + 1;
                queue.offer(top.left);
            }
            if (top.right != null) {
                top.right.val = 2*top.val + 2;
                queue.offer(top.right);
            }
        }
    }

    public boolean find(int target) {
        return dfs(this.root, target);
    }

    private boolean dfs(TreeNode x, int target) {
        if (x == null) return false;
        if (x.val == target) return true;
        return dfs(x.left, target) || dfs(x.right, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        Problem1261 problem1261 = new Problem1261(root);
        System.out.println(problem1261.find(1));
        System.out.println(problem1261.find(2));
    }
}
