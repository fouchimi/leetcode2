public class Problem1019 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[]{0};
        int N = 0;
        ListNode cursor = head;
        while (cursor != null) {
            N++;
            cursor = cursor.next;
        }

        int[] res = new int[N];
        ListNode prev = null, next = null;
        cursor = head;

        while (cursor != null) {
            next = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
        }

        cursor = prev;
        prev = null;

        int i =  N - 1;
        while (cursor != null) {
            if (prev != null) {
                if (cursor.val < prev.val) {
                    res[i] = prev.val;
                } else {
                    int k = i;
                    while (k < N - 1 && cursor.val >= res[k]) k++;
                    if (res[k] <= cursor.val) res[i] = 0;
                    else res[i] = res[k];
                }
            }
            i--;
            prev = cursor;
            cursor = cursor.next;
        }

        return res;
    }

    public static void main(String[] args) {
        Problem1019 problem1019 = new Problem1019();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next.next.next = new ListNode(1);

        int[] res = problem1019.nextLargerNodes(head);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
