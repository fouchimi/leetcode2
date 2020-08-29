import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode>  pq = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val));
        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            ListNode current = top.next;
            top.next = null;
            dummy.next = top;
            dummy = dummy.next;
            if (current != null) pq.offer(current);
        }
        return head.next;
    }

    private void printList(ListNode x) {
        ListNode cursor = x;
        while (cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.next;
        }
    }

    public static void main(String[] args) {
        Problem23 problem23 = new Problem23();
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);
        ListNode third = new ListNode(2);
        third.next = new ListNode(6);
        ListNode list = problem23.mergeKLists(new ListNode[]{first, second, third});
        problem23.printList(list);
    }
}
