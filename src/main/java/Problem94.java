import java.util.ArrayList;
import java.util.List;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode x, List<Integer> list) {
        if(x == null) return;
        dfs(x.left, list);
        list.add(x.val);
        dfs(x.right, list);
    }
}
