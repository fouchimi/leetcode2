public class Problem543 {
    private int left = 0, right = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getLeft(root.left, 1);
        getRight(root.right, 1);
        return Math.max(Math.max(left + right, left), right);
    }

    private void getLeft(TreeNode x, int d) {
        if (x == null) return;
        if (d > left) left = d;
        getLeft(x.left, d + 1);
        getLeft(x.right, d + 1);
    }

    private void getRight(TreeNode x, int d) {
        if (x == null) return;
        if (d > right) right = d;
        getRight(x.right, d + 1);
        getRight(x.right, d + 1);
    }

    public static void main(String[] args) {
        Problem543 problem543 = new Problem543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(problem543.diameterOfBinaryTree(root));
    }
}
