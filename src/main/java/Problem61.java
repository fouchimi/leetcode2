public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        int N = 0;
        ListNode cursor = head;
        while (cursor != null) {
            N++;
            cursor = cursor.next;
        }

        if (N == 0) return head;
        if (k > N) k = k % N;

        while (k > 0) {
            cursor = head;
            int temp = head.val, nextVal;
            while (cursor != null) {
                if (cursor.next != null) {
                    nextVal = cursor.next.val;
                    cursor.next.val = temp;
                    temp = nextVal;
                }
                cursor = cursor.next;
            }
            head.val = temp;
            k--;
        }

        return head;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        Problem61 problem61 = new Problem61();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode x = problem61.rotateRight(head, 4);
        problem61.print(x);

    }
}
