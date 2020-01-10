import java.util.ArrayList;
import java.util.List;

public class Problem222 {

    public int countNodes(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        count(root, list);
        return list.size();
    }

    private void count(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        count(root.left, list);
        count(root.right, list);
    }

    public static void main(String[] args) {
        Problem222 problem222 = new Problem222();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(problem222.countNodes(root));
    }
}
