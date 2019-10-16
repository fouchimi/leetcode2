public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid-1);
        root.right = helper(nums, mid+1, hi);
        return root;
    }

    private void inOrder(TreeNode x) {
        if(x == null) return;
        inOrder(x.left);
        System.out.print(x.val + " ");
        inOrder(x.right);
    }

    public static void main(String[] args) {
        Problem108 problem108 = new Problem108();
        int[] nums = {-10,-3,0,5,9};
        problem108.inOrder(problem108.sortedArrayToBST(nums));
    }
}
