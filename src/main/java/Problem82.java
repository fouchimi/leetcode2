public class Problem82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head, dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = dummy;
        while (cursor != null) {
            ListNode next = cursor;
            int count = 0;
            while (next != null && cursor.val == next.val) {
                count++;
                next = next.next;
            }
            if (count == 1) {
                current.next = cursor;
                current = current.next;
            }
            cursor = next;
        }
        current.next = null;
        return dummy.next;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        Problem82 problem82 = new Problem82();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode x = problem82.deleteDuplicates(head);
        problem82.print(x);
    }
}
