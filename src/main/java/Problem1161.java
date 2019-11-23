import java.util.LinkedList;
import java.util.Queue;

public class Problem1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int maxSum = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1, maxLevel = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                if (q.isEmpty()) break;
                TreeNode top = q.poll();
                if (top.left != null) {
                    sum += top.left.val;
                    q.offer(top.left);
                }

                if (top.right != null) {
                    sum += top.right.val;
                    q.offer(top.right);
                }
            }

            level++;

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        Problem1161 problem1161 = new Problem1161();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(problem1161.maxLevelSum(root));
    }
}
