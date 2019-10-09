import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    private int[] preorder, inorder;
    private Map<Integer, Integer> inorderIndices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i=0; i<inorder.length; i++) inorderIndices.put(inorder[i], i);

        return buildTree(/* pStart= */ 0,
                /* pEnd= */ preorder.length - 1,
                /* iStart= */ 0,
                /* iEnd= */ inorder.length - 1);
    }

    public TreeNode buildTree(int pStart, int pEnd, int iStart, int iEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        int rootVal = preorder[pStart];
        int inorderRootIndex = inorderIndices.get(rootVal);
        int leftPreorderEnd = pStart + inorderRootIndex - iStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pStart + 1, leftPreorderEnd, iStart, inorderRootIndex - 1);
        root.right = buildTree(leftPreorderEnd + 1, pEnd, inorderRootIndex + 1, iEnd);

        return root;
    }

    private void inOrder(TreeNode x) {
        if(x == null) return;
        inOrder(x.left);
        System.out.print(x.val + " ");
        inOrder(x.right);
    }

    private void preOrder(TreeNode x) {
        if(x == null) return;
        System.out.print(x.val + " ");
        preOrder(x.left);
        preOrder(x.right);
    }

    public static void main(String[] args) {
        Problem105 problem105 = new Problem105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = problem105.buildTree(preorder, inorder);
        problem105.preOrder(root);
        System.out.println();
        problem105.inOrder(root);
    }
}
