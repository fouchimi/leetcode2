import java.util.HashMap;
import java.util.Map;

public class Problem138 {
    public Node copyRandomList(Node head) {
        Node cursor = head;
        Map<Node, Node> map = new HashMap<>();
        while (cursor != null) {
            Node newNode = new Node(cursor.val, null, null);
            map.put(cursor, newNode);
            cursor = cursor.next;
        }

        for (Node node : map.keySet()) {
            if (node.next != null) map.get(node).next = map.get(node.next);
            if (node.random != null) map.get(node).random = map.get(node.random);
        }

        return map.get(head);
    }

    public static void main(String[] args){

    }
}
