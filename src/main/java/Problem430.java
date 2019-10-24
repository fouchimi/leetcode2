import java.util.Stack;

public class Problem430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cursor = head;
        while (cursor.next != null) {
            if (cursor.child != null) {
                stack.push(cursor.next);
                cursor.child.prev = cursor;
                cursor.next = cursor.child;
                cursor.child = null;
            } else {
                cursor = cursor.next;
            }
        }

        while (!stack.isEmpty()) {
            Node next = stack.pop();
            next.prev = cursor.next;
            cursor.next = next;
            while (cursor.next != null) {
                cursor = cursor.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Problem430 problem430 = new Problem430();
        Node first = new Node(1, null, null, null);
        Node second = new Node(2, null, null, null);
        Node third = new Node(3, null, null, null);
        Node fourth = new Node(4, null, null, null);
        Node fifth = new Node(5, null, null, null);
        Node sixth = new Node(6, null, null, null);
        Node seventh = new Node(7, null, null, null);
        Node eighth = new Node(8, null, null, null);
        Node ninth = new Node(9, null, null, null);
        Node tenth = new Node(10, null, null, null);
        Node eleventh = new Node(11, null, null, null);
        Node twelfth  = new Node(12, null, null, null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        third.child = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;
        eighth.child = eleventh;
        eleventh.next = twelfth;

        Node cursor = problem430.flatten(first);
        while(cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.next;
        }
        System.out.println();
    }
}
