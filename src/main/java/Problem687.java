public class Problem687 {
    int maxPath = 1;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root,root.val);
        //decrement the answer by 1 where max is the number of nodes in the path and we want the number of edges between them
        return maxPath -1;
    }

    public int helper(TreeNode root, int parent) {
        if (root == null) return 0;
        //get the length of the univalue sequence of the left subtree
        int left = helper(root.left,root.val);
        //get the length of the univalue sequence of the right subtree
        int right = helper(root.right,root.val);
        //check for maximum between the current max and the sum of left and right and  (1 if the node is not a leaf)"
        maxPath = Math.max(maxPath,left + right + (root.left == null && root.right == null ? 0: 1));
        //return the sequence length to the parent where it will be the 0 if the parent is not equal to the children and the maximum univalue sequence between the left and the right added to 1 otherwise
        return root.val == parent ? Math.max(left, right) + 1: 0;
    }

    public static void main(String[] args) {
        Problem687 problem687 = new Problem687();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(problem687.longestUnivaluePath(root));
    }
}
