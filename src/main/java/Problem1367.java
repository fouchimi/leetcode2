import java.util.ArrayList;
import java.util.List;

public class Problem1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null && head == null) return true;
        if (root == null || head == null) return false;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (TreeNode node : list) {
            if (node.val == head.val) {
                if (isSubPathUtil(node, head)) return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        dfs(x.left, list);
        list.add(x);
        dfs(x.right, list);
    }

    private boolean isSubPathUtil(TreeNode x, ListNode head) {
        if (head.next == null) return true;
        if (x.left != null && x.right != null
                && x.left.val == head.next.val
                && x.right.val == head.next.val &&
                ((isSubPathUtil(x.left, head.next) || isSubPathUtil(x.right, head.next)))) return true;

        if (x.left != null && x.left.val == head.next.val && (isSubPathUtil(x.left, head.next))) return true;
        return x.right != null && x.right.val == head.next.val && (isSubPathUtil(x.right, head.next));
    }

    public static void main(String[] args) {
        Problem1367 problem1367 = new Problem1367();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(4);
//        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(1);
//        root.right.left = new TreeNode(2);
//        root.right.left.left = new TreeNode(6);
//        root.right.left.right = new TreeNode(8);
//        root.right.left.right.left = new TreeNode(1);
//        root.right.left.right.right = new TreeNode(3);
//
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(6);

        System.out.println(problem1367.isSubPath(head, root));
    }
}
