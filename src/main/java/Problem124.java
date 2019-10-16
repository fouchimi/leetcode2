public class Problem124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode x) {
        if(x == null) return 0;
        int leftSum = helper(x.left);
        int rightSum = helper(x.right);
        int leftSideSum = x.val + leftSum;
        int rightSideSum = x.val + rightSum;
        int subTreeSum = x.val + leftSideSum + rightSideSum;
        int maxRightOrLeft = Math.max(leftSum, rightSum);
        int maxSidesOrNode = Math.max(x.val, maxRightOrLeft);
        int maxSubtreeOrSidesOrNode = Math.max(subTreeSum, maxSidesOrNode);
        max = Math.max(max, maxSubtreeOrSidesOrNode);
        return maxSidesOrNode;
    }

    public static void main(String[] args) {
        Problem124 problem124 = new Problem124();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(1);
        System.out.println(problem124.maxPathSum(root));
    }
}
