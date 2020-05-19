public class Problem662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    private int size(TreeNode x) {
        if (x == null) return 0;
        int left = 0, right = 0;
        left += size(x.left) + 1;
        right += size(x.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Problem662 problem662 = new Problem662();
        TreeNode x = new TreeNode(0);
    }
}
