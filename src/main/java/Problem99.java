public class Problem99 {
    private TreeNode first = null, second = null;
    private boolean found = false;
    private TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;
    }

    private void inOrder(TreeNode x) {
        if (x == null) return;
        inOrder(x.left);
        if (prev == null) prev = x;
        else {
            if (x.val < prev.val && !found) {
                first = prev;
                found = true;
            }
            if (found && x.val < prev.val) second = x;
            prev = x;
        }
        inOrder(x.right);
    }
    public static void main(String[] args) {
        Problem99 problem99 = new Problem99();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        problem99.recoverTree(root);
    }
}
