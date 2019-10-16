public class Problem124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        int rightSideSum=node.val+rightSum;
        int leftSideSum=node.val+leftSum;
        int subTreeSum = node.val+leftSum+rightSum;
        int maxRightOrLeft =Math.max(leftSideSum, rightSideSum);
        int maxSidesOrNode=Math.max(node.val,maxRightOrLeft);
        int maxSubTreeOrSidesOrNode=Math.max(subTreeSum,maxSidesOrNode );
        maxSum = Math.max(maxSum, maxSubTreeOrSidesOrNode);
        return maxSidesOrNode;
    }
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
