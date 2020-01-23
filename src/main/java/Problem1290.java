public class Problem1290 {
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int ans = 0;
        while (head != null) {
            ans = 2*ans + head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem1290 problem1290 = new Problem1290();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        System.out.println(problem1290.getDecimalValue(head));
    }
}
