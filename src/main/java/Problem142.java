import java.util.HashMap;
import java.util.Map;

public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cursor = head;
        while (cursor != null) {
            if (map.containsKey(cursor)) return cursor;
            map.put(cursor, cursor);
            cursor = cursor.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Problem142 problem142 = new Problem142();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next = head;
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = head.next;
        ListNode res = problem142.detectCycle(head);
        if (res != null) System.out.println(res.val);
    }
}
