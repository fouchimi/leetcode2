public class Problem19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int N = 0, i = 0;
        ListNode cursor = head;
        while (cursor != null) {
            N++;
            cursor = cursor.next;
        }

        cursor = head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode newList = dummy;
        while (cursor != null) {
            if (i == N-n) {
                newList.next = cursor.next;
                cursor = cursor.next;
            } else {
                newList.next = cursor;
                newList = newList.next;
                cursor = cursor.next;
            }
            i++;
        }
        return dummy.next;
    }

    private void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Problem19 problem19 = new Problem19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newList = problem19.removeNthFromEnd(head, 5);
        problem19.print(newList);

    }
}
