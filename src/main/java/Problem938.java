public class Problem938 {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        return getSum(root, L, R);
    }

    private int getSum(TreeNode x, int L, int R) {
        if (x == null) return 0;
        if (x.val >= L && x.val <= R) sum += x.val;
        getSum(x.left, L, R);
        getSum(x.right, L, R);
        return sum;
    }

}
