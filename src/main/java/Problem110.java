public class Problem110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode x) {
        if(x == null) return 0;
        int left = height(x.left);
        int right = height(x.right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        Problem110 problem110 = new Problem110();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right  = new TreeNode(7);

        System.out.println(problem110.isBalanced(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(4);

        System.out.println(problem110.isBalanced(root1));
    }
}
