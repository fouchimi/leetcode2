import java.util.ArrayList;
import java.util.List;

public class Problem988 {
    private char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'e', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private String minStr = null;
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return minStr;
        helper(root, new ArrayList<>());
        return minStr;
    }

    private void helper(TreeNode x, List<Integer> list) {
        if (x == null) return;
        list.add(0, x.val);
        helper(x.left, list);
        helper(x.right, list);
        if (x.left == null && x.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) sb.append(alphabets[list.get(i)]);
            if (minStr == null || sb.toString().compareTo(minStr) < 0) minStr = sb.toString();
        }
        list.remove(0);
    }

    public static void main(String[] args) {
        Problem988 problem988 = new Problem988();
        //0,1,2,3,4,3,4
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(problem988.smallestFromLeaf(root));
    }
}
