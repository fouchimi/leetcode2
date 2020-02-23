import java.util.ArrayList;
import java.util.List;

public class Problem530 {
    public int getMinimumDifference(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                else min = Math.min(min, Math.abs(list.get(i).val - list.get(j).val));
            }
        }
        return min;
    }

    private void dfs(TreeNode x, List<TreeNode> list) {
        if (x == null) return;
        dfs(x.left, list);
        list.add(x);
        dfs(x.right, list);
    }

    public static void main(String[] args) {
        Problem530 problem530 = new Problem530();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(problem530.getMinimumDifference(root));
    }
}
