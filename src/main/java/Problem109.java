import java.util.ArrayList;
import java.util.List;

public class Problem109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode cursor = head;
        List<ListNode> list = new ArrayList<>();
        int N = 0;
        while(cursor != null) {
            list.add(cursor);
            cursor = cursor.next;
            N++;
        }
        return convertListToBST(list, 0, N-1);
    }

    private TreeNode convertListToBST(List<ListNode> list, int lo, int hi) {
        if(lo > hi) return null;
        int mid = lo + (hi-lo) / 2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = convertListToBST(list, lo, mid-1);
        root.right = convertListToBST(list, mid+1, hi);
        return root;
    }

    private void inOrder(TreeNode x) {
        if(x == null) return;
        inOrder(x.left);
        System.out.print(x.val + " ");
        inOrder(x.right);
    }

    public static void main(String[] args) {
        Problem109 problem109 = new Problem109();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = problem109.sortedListToBST(head);
        problem109.inOrder(root);
    }
}
