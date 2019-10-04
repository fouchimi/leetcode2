import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node top = queue.poll();
                if (top != null) list.add(top.val);
                for(int j = 0; top != null && j < top.children.size(); j++) {
                    queue.offer(top.children.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem429 problem429 = new Problem429();
        Node first = new Node(5, new ArrayList<>());
        Node second = new Node(6, new ArrayList<>());
        List<Node> firstList = new ArrayList<>();
        firstList.add(first);
        firstList.add(second);
        Node third = new Node(3, firstList);
        Node fourth = new Node(2, new ArrayList<>());
        Node fifth = new Node(4, new ArrayList<>());
        List<Node> secondList = new ArrayList<>();
        secondList.add(third);
        secondList.add(fourth);
        secondList.add(fifth);
        Node sixth = new Node(1, secondList);
        List<List<Integer>> res = problem429.levelOrder(sixth);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
