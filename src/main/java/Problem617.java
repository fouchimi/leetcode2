import java.util.LinkedList;
import java.util.Queue;

public class Problem617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Queue<TreeNode> fQueue = new LinkedList<>();
        Queue<TreeNode> sQueue = new LinkedList<>();
        fQueue.offer(t1);
        sQueue.offer(t2);
        while (!fQueue.isEmpty() && !sQueue.isEmpty()) {
            TreeNode fTop = fQueue.poll();
            TreeNode sTop = sQueue.poll();
            assert sTop != null;
            fTop.val += sTop.val;

            if (fTop.left != null && sTop.left != null) {
                fQueue.offer(fTop.left);
                sQueue.offer(sTop.left);
            }

            if (fTop.right != null && sTop.right != null) {
                fQueue.offer(fTop.right);
                sQueue.offer(sTop.right);
            }
            if (fTop.left == null) fTop.left = sTop.left;
            if (fTop.right == null) fTop.right = sTop.right;
        }

        return t1;
    }

    private void dfs(TreeNode x) {
        if (x == null) return;
        dfs(x.left);
        System.out.print(x.val + " ");
        dfs(x.right);
    }

    public static void main(String[] args) {
        Problem617 problem617 = new Problem617();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        TreeNode res = problem617.mergeTrees(t1, t2);
        problem617.dfs(res);
    }

}
