public class Problem104 {
    private int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        return dfs(root, 0) + 1;
    }

    private int dfs(TreeNode x, int level) {
        if(x == null) return 0;

        if(level > maxDepth) maxDepth = level;

        dfs(x.left, level+1);
        dfs(x.right, level+1);

        return maxDepth;
    }

    public static void main(String[] args) {
        Problem104 problem104 = new Problem104();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(problem104.maxDepth(root));
    }
}
