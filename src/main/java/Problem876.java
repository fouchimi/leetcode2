public class Problem876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        int N = 0;
        ListNode cursor = head;
        while (cursor != null) {
            ++N;
            cursor = cursor.next;
        }

        int mid = ( N / 2) + 1;
        cursor = head;

        while (mid > 1) {
            --mid;
            cursor = cursor.next;
        }

        return cursor;
    }

    public static void main(String[] args) {
        Problem876 problem876 = new Problem876();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(problem876.middleNode(head).val + " ");
    }
}
