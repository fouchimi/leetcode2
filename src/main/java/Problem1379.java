import java.util.ArrayList;
import java.util.List;

public class Problem1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        List<TreeNode> list = new ArrayList<>();
        dfs(cloned, list);
        for (TreeNode node : list) {
            if (node.val == target.val) return node;
        }
        return null;
    }

    private void dfs(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        dfs(x.left, list);
        list.add(x);
        dfs(x.right, list);
    }
}
