import java.util.*;

public class Problem653 {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer val : list) {
            if (map.containsKey(k-val)) return true;
            else map.put(val, val);
        }
        return false;
    }
    private void dfs(TreeNode x,  List<Integer> list) {
        if (x == null) return;
        list.add(x.val);
        dfs(x.left, list);
        dfs(x.right, list);
    }

    public static void main(String[] args) {
        Problem653 problem653 = new Problem653();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(problem653.findTarget(root, 9));
    }
}
