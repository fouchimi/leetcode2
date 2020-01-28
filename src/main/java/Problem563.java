public class Problem563 {
    private int tiltSum = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return tiltSum;
    }

    private int dfs(TreeNode x) {
        if (x == null) return 0;
        int left = dfs(x.left);
        int right = dfs(x.right);
        tiltSum += Math.abs(left - right);
        return left + right + x.val;
    }

    public static void main(String[] args) {
        Problem563 problem563 = new Problem563();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(problem563.findTilt(root));
    }
}
