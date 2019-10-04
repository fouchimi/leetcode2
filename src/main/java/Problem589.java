import java.util.ArrayList;
import java.util.List;

public class Problem589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        dfs(root, list);
        return list;
    }

    private void dfs(Node x, List<Integer> list) {
        if(x == null) return;
        list.add(x.val);
        for(int i = 0; i < x.children.size(); i++) {
            dfs(x.children.get(i), list);
        }
    }

    public static void main(String[] args) {
        Problem589 problem589 = new Problem589();
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

        List<Integer> list = problem589.preorder(sixth);
        for(Integer val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
