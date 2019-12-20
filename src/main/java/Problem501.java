import java.util.*;

public class Problem501 {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{0};
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = Integer.MIN_VALUE, mode = 0;
        for (Integer key : map.keySet()) max = Math.max(max, map.get(key));

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

    private void helper(TreeNode x, Map<Integer, Integer> map) {
        if (x == null) return;
        map.put(x.val, map.getOrDefault(x.val, 0) + 1);
        helper(x.left, map);
        helper(x.right, map);
    }

    public static void main(String[] args) {
        Problem501 problem501 = new Problem501();
        TreeNode root = new TreeNode(2147483647);
        int[] res = problem501.findMode(root);
        for (int val : res) {
            System.out.println(val + " ");
        }
    }
}
