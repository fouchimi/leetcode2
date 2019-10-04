public class Problem513 {

    int level = -1;
    int val = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }

    private void dfs(TreeNode root, int l) {
        if(root == null) return;
        if(l > level) {
            level = l;
            val = root.val;
        }
        dfs(root.left, l+1);
        dfs(root.right, l+1);
    }

    public static void main(String[] args) {
        Problem513 problem513 = new Problem513();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
//          TreeNode root =  new TreeNode(2);
//          root.left = new TreeNode(1);
//          root.right = new TreeNode(3);

        System.out.println(problem513.findBottomLeftValue(root));
    }
}
