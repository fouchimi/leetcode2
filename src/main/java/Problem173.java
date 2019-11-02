import java.util.ArrayList;
import java.util.List;

public class Problem173 {
    private List<TreeNode> list = new ArrayList<>();
    public Problem173(TreeNode root) {
        inOrder(root);
    }

    private void inOrder(TreeNode x) {
        if (x == null) return;
        inOrder(x.left);
        list.add(x);
        inOrder(x.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) return -1;
        return list.remove(0).val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
