public class Problem377 {

    public int rob(TreeNode root) {
        if(root == null) return 0;
        // Find max sum if we include the current node
        int withNode = root.val;
        if(root.right != null) withNode += rob(root.right.right) + rob(root.right.left);
        if(root.left !=null) withNode += rob(root.left.right) + rob(root.left.left);
        // Find max sum if we exclude the current node
        int withoutNode = rob(root.left) + rob(root.right);
        // Return better case (with node / without)
        return Math.max(withNode, withoutNode);
    }

    public static void main(String[] args) {
        Problem377 problem377 = new Problem377();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(problem377.rob(root));
    }
}
