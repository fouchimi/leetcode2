
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 0; i < to_delete.length; i++) {
            int val = to_delete[i];
            while (!q.isEmpty()) {
                TreeNode newRoot = q.poll();
                if (newRoot.val == val)  {
                    if (newRoot.left != null) q.offer(newRoot.left);
                    if (newRoot.right != null) q.offer(newRoot.right);
                    break;
                }
                if (!isFound(newRoot, q, val, newRoot)) {
                    q.offer(newRoot);
                } else break;
            }
        }
        while (!q.isEmpty()) res.add(q.poll());

        return res;
    }

    private boolean isFound(TreeNode x, Queue<TreeNode> q, int val, TreeNode oldRoot) {
        if (x == null) return false;
        if (x.left != null && x.left.val == val) {
            q.offer(oldRoot);
            if (x.left.left != null) q.offer(x.left.left);
            if (x.left.right != null) q.offer(x.left.right);
            x.left = null;
            return true;
        }

        if (x.right != null && x.right.val == val) {
            q.offer(oldRoot);
            if (x.right.left != null) q.offer(x.right.left);
            if (x.right.right != null) q.offer(x.right.right);
            x.right = null;
            return true;
        }

        return isFound(x.left, q, val, oldRoot) || isFound(x.right, q, val, oldRoot);
    }

    public static void main(String[] args) {
        Problem1110 problem1110 = new Problem1110();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> nodes = problem1110.delNodes(root, new int[]{3, 5});
        for (TreeNode node : nodes) {
            System.out.print(node.val + " ");
        }

    }

}
