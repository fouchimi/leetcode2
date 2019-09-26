import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            finalList.add(0, list);
        }
        return finalList;
    }

    public static void main(String[] args) {
        Problem107 problem107 = new Problem107();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = problem107.levelOrderBottom(root);
        for(List<Integer> l : list) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
    }
}
