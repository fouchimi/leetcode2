import java.util.ArrayList;
import java.util.List;

public class Problem1339 {
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        return 0;
    }

    private void dfs(TreeNode x, List<Integer> list) {
        if (x == null) return;
        dfs(x.left, list);
        list.add(x.val);
        dfs(x.right, list);
    }

    public static void main(String[] args) {
        Problem1339 problem1339 = new Problem1339();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(problem1339.maxProduct(root));
    }
}
