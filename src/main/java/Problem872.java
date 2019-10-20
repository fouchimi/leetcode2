import java.util.ArrayList;
import java.util.List;

public class Problem872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        dfs(root1, firstList);
        dfs(root2, secondList);
        if(firstList.size() != secondList.size()) return false;
        for(int i = 0; i < firstList.size(); i++) {
            if(firstList.get(i) != secondList.get(i)) return false;
        }
        return true;
    }

    private void dfs(TreeNode x, List<Integer> list) {
        if(x == null) return;
        dfs(x.left, list);
        if(x.left == null && x.right == null) list.add(x.val);
        dfs(x.right, list);
    }

}
