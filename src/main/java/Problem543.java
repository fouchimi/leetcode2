import java.util.ArrayList;
import java.util.List;

public class Problem543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        int maxDepth = 0;
        for (TreeNode x : list) {
            int left = getDepth(x.left);
            int right = getDepth(x.right);
            maxDepth = Math.max(maxDepth, left + right);
        }
        return maxDepth;
    }

    private void dfs(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        dfs(x.left, list);
        list.add(x);
        dfs(x.right, list);
    }

    private int getDepth(TreeNode x) {
        if (x == null) return 0;
        int left = 0, right = 0;
        left += getDepth(x.left) + 1;
        right += getDepth(x.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Problem543 problem543 = new Problem543();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(problem543.diameterOfBinaryTree(root));
    }
}
