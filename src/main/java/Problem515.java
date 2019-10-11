import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();
        if(root == null) return finalList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if(top == null) return finalList;
                max = Math.max(max, top.val);
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            finalList.add(max);
        }
        return finalList;
    }

    public static void main(String[] args) {
        Problem515 problem515 = new Problem515();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> list = problem515.largestValues(root);
        for(Integer val : list) {
            System.out.print(val + " ");
        }
    }
}
