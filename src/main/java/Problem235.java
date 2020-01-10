import java.util.ArrayList;
import java.util.List;

public class Problem235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        helper(root, p, list1);
        helper(root, q, list2);
        if (list1.isEmpty() && list2.isEmpty()) return root;
        while (list1.size() > list2.size()) list1.remove(0);
        while (list2.size() > list1.size()) list2.remove(0);
        while (!list1.isEmpty() && list1.get(0) != list2.get(0)) {
            list1.remove(0);
            list2.remove(0);
        }
        return list1.isEmpty() ? root : list1.get(0);
    }

    private void helper (TreeNode x, TreeNode target, List<TreeNode> list) {
        if (x == null || (!list.isEmpty() && list.get(0) == target)) return;
        list.add(0, x);
        helper(x.left, target, list);
        helper(x.right, target, list);
        if (list.get(0) != target) list.remove(0);
    }

    public static void main(String[] args) {
        Problem235 problem235 = new Problem235();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(problem235.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}
