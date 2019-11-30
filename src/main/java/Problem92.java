public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n < m || m == n || head == null) return head;
        int N = 0;
        ListNode cursor = head, p = null, prevFirst = null, first = null, nextSecond = null,  second = null;
        while (cursor != null) {
            if (N == m - 1) {
                prevFirst = p;
                first = cursor;
            }
            if (N == n - 1) {
                second = cursor;
                nextSecond = cursor.next;
            }

            N++;
            p = cursor;
            cursor = cursor.next;
        }

        if (prevFirst != null) prevFirst.next = null;
        if (second != null) second.next = null;

        ListNode prev = null, next;
        cursor = first;

        while (cursor != null) {
            next = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
        }

        if (prevFirst != null) prevFirst.next = prev;
        if (first != null) first.next = nextSecond;

        return m == 1 ? prev : head;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        Problem92 problem92 = new Problem92();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode x = problem92.reverseBetween(head, 2, 4);
        problem92.print(x);
    }
}
