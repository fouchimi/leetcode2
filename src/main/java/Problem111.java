public class Problem111 {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0) + 1;
    }

    private int dfs(TreeNode root, int depth) {
        if(root == null) return 0;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        if(root.left == null && root.right == null) minDepth = Math.min(minDepth, depth);
        return minDepth;
    }

    public static void main(String[] args) {
        Problem111 problem111 = new Problem111();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(problem111.minDepth(root));
    }
}
