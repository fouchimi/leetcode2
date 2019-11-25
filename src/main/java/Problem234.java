public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = head, cursor = dummy;
        while (current != null) {
            cursor.next = new ListNode(current.val);
            cursor = cursor.next;
            current = current.next;
        }
        ListNode newHead = reverse(dummy.next);
        while (head != null && newHead != null) {
            if (head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode x) {
        ListNode prev = null, current = x, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Problem234 problem234 = new Problem234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(problem234.isPalindrome(head));
    }
}
