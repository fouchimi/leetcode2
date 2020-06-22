import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        List<ListNode> tailList = new ArrayList<>(), prefixList = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = null;
            if (cursor.val < x) {
                prefixList.add(cursor);
            } else {
                tailList.add(cursor);
            }
            cursor = next;
        }

        //prefixList.sort((first, second) -> first.val - second.val);

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        cursor = dummy;

        while (!prefixList.isEmpty()) {
            cursor.next = prefixList.remove(0);
            cursor = cursor.next;
        }

        while(!tailList.isEmpty()) {
            cursor.next = tailList.remove(0);
            cursor = cursor.next;
        }
        return dummy.next;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
    }


    public static void main(String[] args) {
        Problem86 problem86 = new Problem86();
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);

        problem86.print(problem86.partition(head, 3));

    }
}
