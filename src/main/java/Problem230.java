import java.util.ArrayList;
import java.util.List;

public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode x = inOrder(root, k, list);
        return list.get(k - 1).val;
    }

    private TreeNode inOrder(TreeNode x, int k, List<TreeNode> list) {
        if (x == null) return null;
        x.left = inOrder(x.left, k, list);
        list.add(x);
        x.right = inOrder(x.right, k, list);
        return x;
    }

    public static void main(String[] args) {
        Problem230 problem230 = new Problem230();
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        //root.left.right = new TreeNode(2);
        System.out.println(problem230.kthSmallest(root, 2));
    }
}
