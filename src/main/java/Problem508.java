import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        for (int key : map.keySet()) max = Math.max(max, map.get(key));
        List<Integer> sumList = new ArrayList<>();
        for (int key : map.keySet()) if (map.get(key) == max) sumList.add(key);
        int[] res = new int[sumList.size()];
        for (int i = 0; i < res.length; i++) res[i] = sumList.get(i);
        return res;
    }

    private int helper(TreeNode x, Map<Integer, Integer> map) {
        if (x == null) return 0;
        int sum = sum(x);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(x.left, map);
        helper(x.right, map);
        return sum;
    }

    private int sum(TreeNode x) {
        if (x == null) return 0;
        int sum = 0;
        sum += x.val + sum(x.left) + sum(x.right);
        return sum;
    }

    public static void main(String[] args) {
        Problem508 problem508 = new Problem508();
        TreeNode x = new TreeNode(5);
        x.left = new TreeNode(2);
        x.right = new TreeNode(-3);
        int[] res = problem508.findFrequentTreeSum(x);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        res = problem508.findFrequentTreeSum(root);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
