import java.util.ArrayList;
import java.util.List;

public class Problem437 {
    private static int numPaths = 0;
    public int pathSum (TreeNode root, int sum) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        while (!list.isEmpty()) {
            dfs (list.remove(0), 0, sum);
        }
        return numPaths;
    }

    private void inOrder(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        inOrder(x.left, list);
        list.add(x);
        inOrder(x.right, list);
    }

    private void dfs (TreeNode x, int sum, int target) {
        if (x == null) return;
        if (sum + x.val == target) numPaths++;
        dfs(x.left, sum + x.val, target);
        dfs(x.right, sum + x.val, target);
    }

    public static void main(String[] args) {
        Problem437 problem437 = new Problem437();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(problem437.pathSum(root, 8));
    }
}
