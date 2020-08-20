import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1339 {
    private  long maxProduct = 0L;
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        int mod = 1000000007;
        int totalSum = getSum(root);
        getMaxProd(root, totalSum);
        return (int) (maxProduct % mod);
    }

    private int getSum(TreeNode x) {
        if (x == null) return 0;
        return x.val + getSum(x.left) + getSum(x.right);
    }

    private int getMaxProd(TreeNode x, int totalSum) {
        if (x == null) return 0;
        int left = getMaxProd(x.left, totalSum);
        int right = getMaxProd(x.right, totalSum);
        int sum = x.val + left + right;
        long currentProd = (long) sum * (totalSum - sum);
        maxProduct = Math.max(currentProd, maxProduct);
        return sum;
    }

    public static void main(String[] args) {
        Problem1339 problem1339 = new Problem1339();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(problem1339.maxProduct(root));
    }
}
