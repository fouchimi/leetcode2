import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res, sum);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list, List<List<Integer>> res, int sum) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
        }
        dfs(root.left, list, res, sum - root.val);
        dfs(root.right, list, res, sum - root.val);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        Problem113 problem113 = new Problem113();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = problem113.pathSum(root, 22);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
        System.out.println();
    }
}
