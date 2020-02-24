public class Problem1315 {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return sum;
    }

    private TreeNode dfs(TreeNode x) {
        if (x == null) return null;
        if (x.val % 2 == 0) {
            if (x.left != null) {
                if (x.left.left != null) sum += x.left.left.val;
                if (x.left.right != null) sum += x.left.right.val;
            }
            if (x.right != null) {
                if (x.right.right != null) sum += x.right.right.val;
                if (x.right.left != null) sum += x.right.left.val;
            }
        }
        x.left = dfs(x.left);
        x.right = dfs(x.right);

        return x;
    }

    public static void main(String[] args) {
        Problem1315 problem1315 = new Problem1315();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        System.out.println(problem1315.sumEvenGrandparent(root));

    }
}
