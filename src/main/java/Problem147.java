public class Problem147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MAX_VALUE), cursor = head;
        while (cursor != null) {
            ListNode next = cursor.next, cur = dummy.next, prev = null;
            cursor.next = null;
            while (cur != null) {
                if (cur.val > cursor.val) break;
                prev = cur;
                cur = cur.next;
            }
            cursor.next = cur;
            if (prev == null) dummy.next = cursor;
            else prev.next = cursor;
            cursor = next;
        }
        return dummy.next;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        Problem147 problem147 = new Problem147();
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode x = problem147.insertionSortList(head);
        problem147.print(x);
    }
}
