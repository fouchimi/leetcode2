import java.util.ArrayList;
import java.util.List;

public class Problem590 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        dfs(root, list);
        list.add(root.val);
        return list;
    }

    private void dfs(Node x, List<Integer> list) {
        if(x == null) return;
        for(int i = 0; i < x.children.size(); i++) {
            dfs(x.children.get(i), list);
            list.add(x.children.get(i).val);
        }
    }

    public static void main(String[] args) {
        Problem590  problem590 = new Problem590();
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
        List<Integer> result = problem590.postorder(sixth);
        for(Integer val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
