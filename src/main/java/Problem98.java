public class Problem98 {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode x, long min, long max) {
        if (x == null) return true;
        long v = x.val;
        return (v > min && v < max) && dfs(x.left, min, v) && dfs(x.right, v, max);
    }

    public static void main(String[] args) {
        Problem98 problem98 = new Problem98();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(problem98.isValidBST(root));
    }
}
