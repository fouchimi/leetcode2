import java.util.ArrayList;
import java.util.List;

public class Problem897 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode head = list.remove(0);
        TreeNode cursor = head;
        while (!list.isEmpty()) {
            cursor.right = list.remove(0);
            cursor = cursor.right;
        }
        return head;
    }

    private TreeNode dfs(TreeNode x, List<TreeNode> l) {
        if(x == null) return null;
        x.left = dfs(x.left, l);
        l.add(x);
        x.right = dfs(x.right, l);
        x.left = null;
        x.right = null;
        return x;
    }

    public static void main(String[] args) {
        Problem897 problem897 = new Problem897();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        TreeNode cursor = problem897.increasingBST(root);
        while (cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.right;
        }
    }
}
