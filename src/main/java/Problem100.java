import java.util.LinkedList;
import java.util.Queue;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) return false;
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while(!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pTop = pQueue.poll();
            TreeNode qTop = qQueue.poll();
            if (pTop != null && qTop != null && pTop.val != qTop.val) return false;
            if (pTop != null && qTop != null && pTop.left != null && qTop.left == null) return false;
            if (pTop != null && qTop != null && pTop.left == null && qTop.left != null) return false;
            if (pTop != null && qTop != null && pTop.right != null && qTop.right == null) return false;
            if (pTop != null && qTop != null && pTop.right == null && qTop.right != null) return false;
            if (pTop != null && qTop != null && pTop.left != null) {
                pQueue.offer(pTop.left);
                qQueue.offer(qTop.left);
            }
            if (pTop != null && qTop != null && pTop.right != null && qTop.right != null) {
                pQueue.offer(pTop.right);
                qQueue.offer(qTop.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem100 problem100 = new Problem100();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(problem100.isSameTree(p, q));
    }

}
