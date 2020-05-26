public class Problem1448 {

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        countGoodNodes(root, root.val, count);
        return count[0];
    }

    private void countGoodNodes(TreeNode x, int val, int[] count) {
        if (x == null) return;
        if (x.val >= val) {
            count[0]++;
        }
        countGoodNodes(x.left, Math.max(x.val, val), count);
        countGoodNodes(x.right, Math.max(x.val, val), count);
    }

    public static void main(String[] args) {
        Problem1448 problem1448 = new Problem1448();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(problem1448.goodNodes(root));
    }
}
