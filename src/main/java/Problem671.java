import java.util.*;

public class Problem671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.size() < 2 ? -1 : list.get(1);
    }

    private void dfs(TreeNode x, Set<Integer> set) {
        if (x == null) return;
        set.add(x.val);
        dfs(x.left, set);
        dfs(x.right, set);
    }

    public static void main(String[] args) {
        Problem671 problem671 = new Problem671();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left  = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(problem671.findSecondMinimumValue(root));
    }
}
