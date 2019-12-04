import java.util.HashMap;
import java.util.Map;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode cursor = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while (cursor != null) {
            if (map.containsKey(cursor)) return true;
            map.put(cursor, cursor);
            cursor = cursor.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem141 problem141 = new Problem141();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(problem141.hasCycle(head));
    }
}
