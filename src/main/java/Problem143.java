import java.util.ArrayList;
import java.util.List;

public class Problem143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = null;
            list.add(cursor);
            cursor = next;
        }

        cursor = head;
        int i = 0, j = list.size() - 1;

        for (; i < j; i++, j--) {
            cursor.next = list.get(i);
            cursor = cursor.next;
            cursor.next = list.get(j);
            cursor = cursor.next;
        }
    }


        public static void main(String[] args) {
        Problem143 problem143 = new Problem143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        problem143.reorderList(head);
    }
}
