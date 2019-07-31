
public class Problem993 {

    public boolean isCousins(TreeNode root, int x, int  y) {
        TreeNode[] parents = new TreeNode[2];
        int[] levels = new int[2];
        dfs(root, x, 0, 0, parents, null, levels);
        dfs(root, y, 0, 1, parents, null, levels);
        return parents[0] != parents[1] && levels[0] == levels[1];
    }

    private void dfs(TreeNode root, int val, int depth, int index, TreeNode[] parents, TreeNode parent, int[] levels) {
        if(root == null) return;
        if(root.val == val) {
            parents[index] = parent;
            levels[index] = depth;
            return;
        }
        dfs(root.left, val, depth + 1, index, parents, root, levels);
        dfs(root.right, val, depth + 1, index, parents, root, levels);
    }

    public static void main(String[] args) {
        Problem993 problem993 = new Problem993();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(problem993.isCousins(root, 5, 4));
    }
}
