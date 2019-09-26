import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if(root == null) return finalList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                list.add(top.val);
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            finalList.add(list);
        }
        return finalList;
    }

    public static void main(String[] args) {
        Problem102 problem102 = new Problem102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = problem102.levelOrder(root);
        for(List<Integer> l : list) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + ", ");
            }
            System.out.println();
        }

    }
}
