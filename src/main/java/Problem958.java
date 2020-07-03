import java.util.*;

public class Problem958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                flag = true;
            } else {
                if (flag) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem958 problem958 = new Problem958();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.left.left.left.left = new TreeNode(15);
        System.out.println(problem958.isCompleteTree(root));
    }

}
