public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        if (left != null && right != null)  {
            root.left = right;
            root.right = left;
        } else if (left != null) {
            root.right = left;
            root.left = null;
        }
        else if (right != null) {
            root.left = right;
            root.right = null;
        }
        return root;
    }

    private void printTree(TreeNode x) {
        if (x == null) return;
        printTree(x.left);
        System.out.print(x.val + " ");
        printTree(x.right);
    }

    public static void main(String[] args) {
        Problem226 problem226 = new Problem226();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left= new TreeNode(6);
//        root.right.right = new TreeNode(9);

        problem226.printTree(problem226.invertTree(root));
    }
}
