import java.util.*;

public class Problem987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        dfs(root, 0, map);
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>(entry.getValue());
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }

    private void dfs(TreeNode x, int index, Map<Integer, List<Integer>> map) {
        if (x == null) return;
        dfs(x.left, index - 1, map);
        if (!map.containsKey(index)) {
            List<Integer> list = new ArrayList<>();
            list.add(0, x.val);
            map.put(index, list);
        } else {
            map.get(index).add(x.val);
        }
        dfs(x.right, index + 1, map);
    }

    public static void main(String[] args) {
        Problem987 problem987 = new Problem987();
        TreeNode x = new TreeNode(3);
        x.left = new TreeNode(9);
        x.right = new TreeNode(20);
        x.right.left = new TreeNode(15);
        x.right.right = new TreeNode(7);

        List<List<Integer>> ans = problem987.verticalTraversal(x);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
