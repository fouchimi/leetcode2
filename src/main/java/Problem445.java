
import java.util.ArrayList;
import java.util.List;

public class Problem445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        while(l1 != null) {
            firstList.add(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            secondList.add(l2.val);
            l2 = l2.next;
        }

        int i = firstList.size() - 1, j = secondList.size() - 1, sum = 0;

        ListNode prev = null, node = null;
        for (; i >= 0 && j >= 0; i--, j--) {
            sum += firstList.get(i) + secondList.get(j);
            node = new ListNode(sum % 10);
            sum /= 10;
            node.next = prev;
            prev = node;
        }

        while (i >= 0) {
            sum += firstList.get(i);
            node = new ListNode(sum % 10);
            sum /= 10;
            node.next = prev;
            prev = node;
            i--;
        }

        while (j >= 0) {
            sum += secondList.get(j);
            node = new ListNode(sum % 10);
            sum /= 10;
            node.next = prev;
            prev = node;
            j--;
        }

        if (sum > 0) {
            node = new ListNode(sum);
            node.next = prev;
        }

        return node;
    }

    private void print(ListNode x) {
        while (x != null) {
            System.out.print(x.val + " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        Problem445 problem445 = new Problem445();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = problem445.addTwoNumbers(l1, l2);
        problem445.print(res);

    }
}
