public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cursor = head;
        ListNode current = dummy;
        while (cursor != null) {
            if (current.val != cursor.val) {
                current.next = cursor;
                current = current.next;
            }
            cursor = cursor.next;
        }
        current.next = null;
        return dummy.next;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val +  " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        Problem83 problem83 = new Problem83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);
        ListNode res = problem83.deleteDuplicates(head);
        problem83.print(res);
    }
}
