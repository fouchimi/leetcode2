public class Problem148 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        int N = 0;
        ListNode cursor = head;

        while(cursor != null) {
            N++;
            cursor = cursor.next;
        }

        int mid = N/2;

        cursor = head;

        while(mid > 1) {
            cursor = cursor.next;
            mid--;
        }

        ListNode next = cursor.next;
        cursor.next = null;

        ListNode first = sortList(head);
        ListNode second = sortList(next);

        return merge(first, second);

    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cursor = dummy;

        while (first != null && second != null) {
            if (first.val < second.val) {
                cursor.next = new ListNode(first.val);
                first = first.next;
            } else {
                cursor.next = new ListNode(second.val);
                second = second.next;
            }
            cursor = cursor.next;
        }

        ListNode l = first == null ? second : first;

        while(l != null) {
            cursor.next = new ListNode(l.val);
            l = l.next;
            cursor = cursor.next;
        }
        return dummy.next;
    }
}
