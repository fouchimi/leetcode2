public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddList = new ListNode(Integer.MIN_VALUE), evenList = new ListNode(Integer.MIN_VALUE);
        ListNode oddCursor = oddList, evenCursor = evenList, cursor = head;
        int N = 1;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = null;
            if (N % 2 != 0) {
                oddCursor.next = cursor;
                oddCursor = oddCursor.next;
            } else {
                evenCursor.next = cursor;
                evenCursor = evenCursor.next;
            }
            N++;
            cursor = next;
        }

        oddCursor.next = evenList.next;

        return head;
    }

    public static void main(String[] args) {
        Problem328 problem328 = new Problem328();

    }
}
