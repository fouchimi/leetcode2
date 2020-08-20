import java.util.ArrayList;
import java.util.List;

public class Problem1038 {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(root, list);
        for (TreeNode node : list) {
            int[] dp = new int[1];
            dfs(node, root, dp);
            tempList.add(dp[0]);
        }
        int index = 0;
        for (TreeNode node : list) {
            node.val = tempList.get(index);
            index++;
        }
        return root;
    }
 
    private void helper(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        helper(x.left, list);
        list.add(x);
        helper(x.right, list);
    }

    private void dfs(TreeNode x, TreeNode root, int[] dp) {
        if (root == null) return;
        if (root.val >= x.val) dp[0] += root.val;
        dfs(x, root.left, dp);
        dfs(x, root.right, dp);
    }


    public static void main(String[] args) {
        Problem1038 problem1038 = new Problem1038();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);
        problem1038.bstToGst(root);

    }
}
