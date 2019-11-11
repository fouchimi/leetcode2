public class Problem1022 {
    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return res;
        helper(root, "");
        return res;
    }

    private void helper(TreeNode x, String val) {
        if (x == null) return;
        if (x.left == null && x.right == null) {
            val += x.val;
            int sum = 0, i = 0;
            while (i < val.length()) {
                sum  = 2*sum + Character.getNumericValue(val.charAt(i));
                i++;
            }
            res += sum;
        }
        helper(x.left, val + x.val);
        helper(x.right, val + x.val);
    }


    public static void main(String[] args) {
        Problem1022  problem1022 = new Problem1022();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(problem1022.sumRootToLeaf(root));
    }
}
