import java.util.ArrayList;
import java.util.List;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode cursor = head, pivot = null, prev = null;
        while (cursor != null) {
            if (cursor.val == x) {
                pivot = cursor;
                break;
            }
            prev = cursor;
            cursor = cursor.next;
        }

        List<ListNode> lessThanPivotList = new ArrayList<>();
        List<ListNode> greatOrEqualThanPivotList = new ArrayList<>();

        cursor = pivot != null ? pivot : head;

        while (cursor != null) {
            if (cursor.val < x) lessThanPivotList.add(cursor);
            else greatOrEqualThanPivotList.add(cursor);
            cursor = cursor.next;
        }

        for (ListNode node : lessThanPivotList) node.next = null;
        for (ListNode node : greatOrEqualThanPivotList) node.next = null;

        if (pivot == null) {

            for (int i = 1; i < lessThanPivotList.size(); i++) {
                lessThanPivotList.get(i-1).next = lessThanPivotList.get(i);
            }

            for (int j = 1; j < greatOrEqualThanPivotList.size(); j++) {
                greatOrEqualThanPivotList.get(j-1).next = greatOrEqualThanPivotList.get(j);
            }

            if (lessThanPivotList.isEmpty() || greatOrEqualThanPivotList.isEmpty()) return head;

            lessThanPivotList.get(lessThanPivotList.size() - 1).next = greatOrEqualThanPivotList.get(0);
            return lessThanPivotList.get(0);

        } else {
            ListNode tailList = new ListNode(Integer.MIN_VALUE);
            ListNode cursorList = tailList;

            while (!greatOrEqualThanPivotList.isEmpty()) {
                cursorList.next = greatOrEqualThanPivotList.remove(0);
                cursorList = cursorList.next;
            }

            if (prev == null) {
                for (int i = 1; i < lessThanPivotList.size(); i++) {
                    lessThanPivotList.get(i-1).next = lessThanPivotList.get(i);
                }
                if (lessThanPivotList.isEmpty()) return tailList.next;
                lessThanPivotList.get(lessThanPivotList.size() - 1).next = tailList.next;
                return lessThanPivotList.get(0);

            } else {
                prev.next = pivot;
                pivot.next = cursorList.next;
            }
            cursor = head;
            ListNode temp = null;
            while (cursor != null) {
                if (!lessThanPivotList.isEmpty() && cursor.val > lessThanPivotList.get(0).val) break;
                temp = cursor;
                cursor = cursor.next;
            }
            while (!lessThanPivotList.isEmpty() && temp != null) {
                temp.next = lessThanPivotList.remove(0);
                temp = temp.next;
            }
            if (temp != null) temp.next = cursor;
            return head;
        }
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
