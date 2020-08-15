import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode[] arr = new TreeNode[list.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
        Arrays.sort(arr, (first, second) -> first.val - second.val);
        root = buildTree(arr, 0, arr.length - 1);
        return root;
    }

    private TreeNode buildTree(TreeNode[] arr, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(arr[mid].val);
        root.left = buildTree(arr, lo, mid - 1);
        root.right = buildTree(arr, mid + 1, hi);
        return root;
    }

    private void inOrder(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        inOrder(x.left, list);
        list.add(x);
        inOrder(x.right, list);
    }

    public static void main(String[] args) {
        Problem1382 problem1382 = new Problem1382();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        problem1382.balanceBST(root);
    }

}
