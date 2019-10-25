public class Problem1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }

    private TreeNode helper(TreeNode root, int limit, int curSum){
        if (root == null) return null;

        if (root.left == null && root.right == null){
            if(curSum + root.val < limit) return null;
            else return root;
        }

        root.left = helper(root.left, limit, curSum + root.val);
        root.right = helper(root.right, limit, curSum + root.val);

        return (root.left == null && root.right == null) ? null : root;
    }

    public static void main(String[] args) {
        Problem1080 problem1080 = new Problem1080();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(17);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(-5);
        root.right.left = new TreeNode(4);

        TreeNode r = problem1080.sufficientSubset(root, -1);

    }
}
