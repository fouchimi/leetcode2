import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();
        if(root == null) return finalList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        finalList.add(root.val);
        while (!queue.isEmpty()) {
            int level = queue.size();
            boolean isAdded = false;
            for(int i = 0; i < level; i++) {
                TreeNode top = queue.poll();
                if (top == null) continue;
                if (top.right != null) {
                    if(!isAdded) {
                        finalList.add(top.right.val);
                        isAdded = true;
                    }
                    queue.offer(top.right);
                }
                if (top.left != null) {
                    if (!isAdded) {
                        finalList.add(top.left.val);
                        isAdded = true;
                    }
                    queue.offer(top.left);
                }
            }
        }
        return finalList;
    }

    public static void main(String[] args) {
        Problem199 problem199 = new Problem199();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> list = problem199.rightSideView(root);
        for(Integer val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
