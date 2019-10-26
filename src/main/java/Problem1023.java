import java.util.*;

public class Problem1023 {

    int depth = -1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> leaves = new ArrayList<>();
        getLeaves(root, 0, leaves);
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        for (TreeNode leaf : leaves) {
            map.put(leaf, new ArrayList<>());
            getAncestors(root, map, leaf);
        }

        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<TreeNode, List<TreeNode>> pair = (Map.Entry<TreeNode, List<TreeNode>>) itr.next();
            Iterator it = map.entrySet().iterator();
            int count = 0;
            while (it.hasNext()) {
                Map.Entry<TreeNode, List<TreeNode>> p = (Map.Entry<TreeNode, List<TreeNode>>) it.next();
                if (pair.getKey() == p.getKey()) continue;
                else if (pair.getValue().get(0) == p.getValue().get(0)) {
                    count++;
                    p.getValue().remove(0);
                } else p.getValue().remove(0);
            }
            if (count == map.size()) {
                return pair.getValue().get(0);
            }

            pair.getValue().remove(0);
        }

        return null;
    }

    private boolean getAncestors(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode target) {
        if (root == null) return false;
        if (root == target) return true;
        if (getAncestors(root.left, map, target) || getAncestors(root.right, map, target)) {
            map.get(target).add(0, root);
        }
        return false;
    }

    private void getLeaves(TreeNode x, int level, List<TreeNode> list) {
        if (x == null) return;
        if (level > depth) {
            if (list.isEmpty()) list.add(x);
            else {
                list.clear();
                list.add(x);
            }
            depth = level;
        }

        if (level == depth) list.add(x);

        getLeaves(x.left, level+1, list);
        getLeaves(x.right, level+1, list);
    }

    public static void main(String[] args) {

    }
}
