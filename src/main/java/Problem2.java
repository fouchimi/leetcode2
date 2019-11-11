public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum += l1.val;
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum += l2.val;
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
            l2 = l2.next;
        }
        if (sum > 0) curr.next = new ListNode(sum % 10);
        return dummy.next;
    }

    private void print(ListNode l) {
        if (l == null) return;
        ListNode current = l;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = problem2.addTwoNumbers(l1, l2);
        problem2.print(res);
    }
}
