public class Problem203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cursor = head;
        ListNode current = dummy;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = null;
            if (cursor.val != val) {
                current.next = cursor;
                current = current.next;
            }
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
        Problem203 problem203 = new Problem203();
        //1,2,6,3,4,5,6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        head = problem203.removeElements(head, 6);
        problem203.print(head);

    }
}
