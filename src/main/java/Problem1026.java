import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1026 {
    public int maxAncestorDiff(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        inOrder(root, nodeList);
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        for(TreeNode node : nodeList) {
            List<TreeNode> parentList = new ArrayList<>();
            getParents(root, node, parentList);
            map.put(node, parentList);
        }
        int max = Integer.MIN_VALUE;
        for(TreeNode node : map.keySet()) {
            List<TreeNode> childrenNodes = map.get(node);
            for(TreeNode child : childrenNodes) {
                max = Math.max(max, Math.abs(node.val - child.val));
            }
        }
        return max;
    }

    private void inOrder(TreeNode x, List<TreeNode> list) {
        if(x == null) return;
        list.add(x);
        inOrder(x.left, list);
        inOrder(x.right, list);
    }

    private boolean getParents(TreeNode x, TreeNode target, List<TreeNode> parentList) {
        if(x == null) return false;
        if(x == target) return true;
        if(getParents(x.left, target, parentList) || getParents(x.right, target, parentList)) {
            parentList.add(x);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem1026 problem1026 = new Problem1026();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(problem1026.maxAncestorDiff(root));
    }
}
