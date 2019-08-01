import java.util.HashSet;
import java.util.Set;

public class Problem965 {
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        isUnivalTreeUtil(root, set);
        return set.size() == 1;
    }

    private void isUnivalTreeUtil(TreeNode root, Set<Integer> set) {
        if(root == null) return;
        isUnivalTreeUtil(root.left, set);
        set.add(root.val);
        isUnivalTreeUtil(root.right, set);
    }
}
