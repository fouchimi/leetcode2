import java.util.LinkedList;
import java.util.Queue;

public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                if (top.left.left == null && top.left.right == null) sum += top.left.val;
                queue.offer(top.left);
            }
            if (top.right != null) queue.offer(top.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem404 problem404 = new Problem404();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(problem404.sumOfLeftLeaves(root));
    }
}

