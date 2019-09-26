import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top != null) {
                    if(level % 2 == 0) l.add(top.val);
                    else l.add(0, top.val);
                    if (top.left != null) queue.offer(top.left);
                    if (top.right != null) queue.offer(top.right);
                }
            }
            level++;
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        Problem103 problem103 = new Problem103();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> list = problem103.zigzagLevelOrder(root);
        for(List<Integer> l : list) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
    }
}
