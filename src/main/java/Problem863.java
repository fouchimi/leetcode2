import java.util.*;

public class Problem863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(root == target) distanceKUtil(root, K, res);
        else {
            Queue<TreeNode> ancestors = new LinkedList<>();
            getAncestors(root, target, ancestors);
            int level = 1;
            while (!ancestors.isEmpty()) {
                TreeNode ancestor = ancestors.poll();
                if (K == level) {
                    res.add(ancestor.val);
                    break;
                } else if (K-level > 0) {
                    if (isLeftChild(ancestor.left, target)) distanceKUtil(ancestor.right, K-level-1, res);
                    else distanceKUtil(ancestor.left, K-level-1, res);
                }
                level++;
            }
            distanceKUtil(target, K, res);
        }
        return res;
    }

    private boolean getAncestors(TreeNode x, TreeNode target, Queue<TreeNode> ancestors) {
        if(x == null) return false;
        if(x == target) return true;
        if (getAncestors(x.left, target, ancestors) || getAncestors(x.right, target, ancestors)) {
            ancestors.offer(x);
            return true;
        }
        return false;
    }

    private void distanceKUtil(TreeNode x, int K, List<Integer> res) {
        if(x == null || K < 0) return;
        if(K == 0) {
            res.add(x.val);
            return;
        }
        distanceKUtil(x.left, K-1, res);
        distanceKUtil(x.right, K-1, res);
    }

    private boolean isLeftChild(TreeNode parent, TreeNode target) {
        if(parent == null) return false;
        if(parent == target) return true;
        else return isLeftChild(parent.left, target) || isLeftChild(parent.right, target);
    }


    public static void main(String[] args) {
        Problem863 problem863 = new Problem863();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        List<Integer> l = problem863.distanceK(root, root.left.right.right , 5);
        for(Integer val : l) System.out.print(val + " ");
        System.out.println();

    }
}
