import java.util.ArrayList;
import java.util.List;

public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode x, List<Integer> list) {
        if(x == null) return;
        list.add(x.val);
        dfs(x.left, list);
        dfs(x.right, list);
    }
}
