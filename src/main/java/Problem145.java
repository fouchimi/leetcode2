import java.util.ArrayList;
import java.util.List;

public class Problem145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode x, List<Integer> list) {
        if(x == null) return;
        dfs(x.left, list);
        dfs(x.right, list);
        list.add(x.val);
    }
}
