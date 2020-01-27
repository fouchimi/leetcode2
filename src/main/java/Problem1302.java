import java.util.LinkedHashMap;
import java.util.Map;

public class Problem1302 {
    private int max = 0;
    public int deepestLeavesSum(TreeNode root) {
        Map<TreeNode, Integer> map = new LinkedHashMap<>();
        dfs(root, 0, map);
        int sum = 0;
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) sum += entry.getKey().val;
        }
        return sum;
    }

    private void dfs(TreeNode x, int depth, Map<TreeNode, Integer> map) {
        if (x == null) return;
        if (x.left == null && x.right == null) {
            map.put(x, depth + 1);
            max = Math.max(max, depth + 1);
        }
        dfs(x.left, depth + 1, map);
        dfs(x.right, depth + 1, map);
    }

    public static void main(String[] args) {
        Problem1302 problem1302 = new Problem1302();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(problem1302.deepestLeavesSum(root));

    }
}
