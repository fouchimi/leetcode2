import java.util.LinkedList;
import java.util.Queue;

public class Problem662 {

    private class Pair {
        TreeNode node;
        int index;
        private Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int startIndex = queue.peek().index;
            int endIndex = startIndex;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if (pair == null) continue;
                endIndex = pair.index;
                TreeNode node = pair.node;
                if (node.left != null) queue.offer(new Pair(node.left, 2 * endIndex));
                if (node.right != null) queue.offer(new Pair(node.right, 2 * endIndex + 1));
            }
            max = Math.max(max, endIndex - startIndex + 1);
        }
        return max;
    }
}
