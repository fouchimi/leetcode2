import java.util.*;

public class Problem133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if(top.neighbors != null) {
                Node parentNode = map.get(top);
                if (parentNode.neighbors == null) parentNode.neighbors = new ArrayList<>();
                for(Node neighbor : top.neighbors) {
                    if(!map.containsKey(neighbor)) {
                        newNode = new Node(neighbor.val);
                        map.put(neighbor, newNode);
                        queue.offer(neighbor);
                        parentNode.neighbors.add(newNode);
                    } else {
                        parentNode.neighbors.add(map.get(neighbor));
                    }
                }
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Problem133 problem133 = new Problem133();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        first.children = Arrays.asList(second, fourth);
        second.children = Arrays.asList(first, third);
        third.children = Arrays.asList(second, fourth);
        fourth.children = Arrays.asList(first, third);

        problem133.cloneGraph(first);
    }
}
