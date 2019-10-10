import java.util.LinkedList;
import java.util.Queue;

public class Problem700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top == null) return null;
                if(top.val == val) return top;
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
        }
        return null;
    }

    private void inOrder(TreeNode x) {
        if (x == null) return;
        inOrder(x.left);
        System.out.print(x.val + " ");
        inOrder(x.right);
    }

    public static void main(String[] args) {
        Problem700 problem700 = new Problem700();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode result = problem700.searchBST(root, 2);
        if(result != null) {
            problem700.inOrder(result);
            System.out.println();
        }
    }
}
