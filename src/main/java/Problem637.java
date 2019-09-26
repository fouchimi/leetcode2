import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list =  new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                sum += top.val;
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            list.add(sum / size);
        }
        return list;
    }

    public static void main(String[] args) {
        Problem637 problem637 = new Problem637();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> resultList = problem637.averageOfLevels(root);
        for(double val : resultList) {
            System.out.print(val + " ");
        }
    }
}
