public class Problem1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) return null;
        return root;
    }

    private void print(TreeNode x) {
        if (x == null) return;
        print(x.left);
        System.out.print(x.val + " ");
        print(x.right);
    }

    public static void main(String[] args) {
        Problem1325 problem1325 = new Problem1325();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        problem1325.print(problem1325.removeLeafNodes(root, 2));

    }
}

