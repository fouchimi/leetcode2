
public class Problem1123 {

    TreeNode res = null;
    int dep = -1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int l = dfs(root.left, depth + 1);
        int r = dfs(root.right, depth + 1);
        if (l == r && dep <= l) {
            res = root;
            dep = l;
            return l;
        } else {
            return Math.max(l, r);
        }
    }

    public static void main(String[] args) {
        Problem1123 problem1123 = new Problem1123();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(5);
//        root.left.right = new TreeNode(5);
        System.out.println(problem1123.lcaDeepestLeaves(root).val);
    }
}
