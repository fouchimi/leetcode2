import java.util.Stack;

public class Problem236 {
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Stack<TreeNode> pStack = new Stack<>(), qStack = new Stack<>();
        getAncestors(root, p, pStack);
        found = false;
        getAncestors(root, q, qStack);
        if (pStack.size() > qStack.size()) {
            while (pStack.size() > qStack.size()) pStack.pop();
        } else if (pStack.size() < qStack.size()) {
            while (pStack.size() < qStack.size()) qStack.pop();
        }
        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            if (pStack.peek() == qStack.peek()) return pStack.peek();
            pStack.pop();
            qStack.pop();
        }
        return root;
    }

    private void getAncestors(TreeNode root, TreeNode x, Stack<TreeNode> stack) {
        if (root == null) return;
        if (!found) stack.push(root);
        if (root == x) {
            found = true;
            return;
        }
        getAncestors(root.left, x, stack);
        getAncestors(root.right, x, stack);
        if (!found) stack.pop();
    }

    public static void main(String[] args) {
        Problem236 problem236 = new Problem236();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(problem236.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
