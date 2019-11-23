public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cursor = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }

        while (l1 != null) {
            cursor.next = l1;
            l1 = l1.next;
            cursor = cursor.next;
        }

        while (l2 != null) {
            cursor.next = l2;
            l2 = l2.next;
            cursor = cursor.next;
        }
        return dummy.next;
    }

    private void print(ListNode head) {
        ListNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.next;
        }
    }

    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode res = problem21.mergeTwoLists(first, second);
        problem21.print(res);
    }
}
