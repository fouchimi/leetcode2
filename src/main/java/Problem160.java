import java.util.HashMap;
import java.util.Map;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cursor = headA;
        while (cursor != null) {
            map.put(cursor, cursor);
            cursor = cursor.next;
        }
        cursor = headB;
        while (cursor != null) {
            if (map.get(cursor) != null) return cursor;
            cursor = cursor.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Problem160 problem160 = new Problem160();
    }
}
