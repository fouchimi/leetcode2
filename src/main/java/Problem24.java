import java.util.ArrayList;
import java.util.List;

public class Problem24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE), current = head;
        ListNode cursor = dummy;
        List<ListNode> list = new ArrayList<>();
        while (current != null) {
            if (list.size() == 2) {
                while (!list.isEmpty()) {
                    cursor.next = list.get(list.size()-1);
                    cursor = cursor.next;
                    list.remove(list.size()-1);
                }
            }
            ListNode next = current.next;
            current.next = null;
            list.add(current);
            current = next;
        }

        while (!list.isEmpty()) {
            cursor.next = list.get(list.size()-1);
            cursor = cursor.next;
            list.remove(list.size()-1);
        }

        return dummy.next;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        ListNode ans = problem24.swapPairs(head);
        problem24.print(ans);

    }
}
