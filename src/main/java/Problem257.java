import java.util.ArrayList;
import java.util.List;

public class Problem257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, "", list);
        return list;
    }

    private TreeNode dfs(TreeNode root, String path, List<String> list) {
        if(root == null) return null;
        root.left = dfs(root.left, path + root.val + "->", list);
        root.right = dfs(root.right, path + root.val + "->", list);
        if (root.left == null && root.right == null) list.add(path + root.val);
        return root;
    }

    public static void main(String[] args) {
        Problem257 problem257 = new Problem257();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = problem257.binaryTreePaths(root);
        for(String str : res) {
            System.out.println(str);
        }
    }
}
