public class Problem129 {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,  0);
        return sum;
    }

    private TreeNode dfs(TreeNode x,  int currSum) {
        if (x == null) return null;
        x.left = dfs(x.left, 10*currSum + x.val);
        x.right = dfs(x.right, 10*currSum + x.val);
        if(x.left == null && x.right == null) sum += 10*currSum + x.val;
        return x;
    }

    public static void main(String[] args) {
        Problem129 problem129 = new Problem129();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(problem129.sumNumbers(root));
    }
}
