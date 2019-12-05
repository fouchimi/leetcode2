public class Problem237 {
    public void deleteNode(ListNode node) {
        ListNode cursor = node;
        while (cursor != null) {
            if (cursor.next != null) {
                cursor.val = cursor.next.val;
                if (cursor.next.next == null) cursor.next = null;
            }
            cursor = cursor.next;
        }
    }
}
