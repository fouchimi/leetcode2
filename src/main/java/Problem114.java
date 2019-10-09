public class Problem114 {

    public void flatten(TreeNode root) {
        if (root == null) return;
        dfs(root);
        //print(root);
    }

    private TreeNode dfs(TreeNode x) {
        if(x == null) return null;
        x.left = dfs(x.left);
        x.right = dfs(x.right);
        TreeNode temp = x.right, cursor = x;
        x.right = x.left;
        while (cursor.right != null) cursor = cursor.right;
        cursor.right = temp;
        x.left = null;
        return x;
    }

    private void print(TreeNode x) {
        if(x == null) return;
        TreeNode cursor = x;
        while (cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem114 problem114 = new Problem114();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        problem114.flatten(root);
    }
}
