public class Problem654 {
    TreeNode root;
    int N = 0;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        boolean[] visited = new boolean[nums.length];
        int mid = nums.length / 2, N = nums.length;
        visited[mid] = true;
        root = dfs(root, nums, nums[mid], visited);
        return root;
    }

    private TreeNode dfs(TreeNode x, int[] nums, int val, boolean[] visited) {
        if (x == null) x = new TreeNode(val);
        if (N == 0) return x;
        int mid = nums.length/2, maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE, leftIndex = -1, rightIndex = -1;
        int i = mid - 1, j = mid + 1;
        for (; i >= 0; i--)  {
            if (visited[i]) continue;
            if (nums[i] > maxLeft) {
                maxLeft = nums[i];
                leftIndex = i;
                N--;
            }
        }

        for (; j < nums.length; j++) {
            if (visited[j]) continue;
            if (nums[j] > maxRight) {
                maxRight = nums[j];
                rightIndex = j;
                N--;
            }
        }

        if (leftIndex > -1) visited[leftIndex] = true;
        if (rightIndex > -1) visited[rightIndex] = true;

        x.left = dfs(x.left, nums, maxLeft, visited);
        x.right = dfs(x.right, nums, maxRight, visited);
        return x;
    }

    public static void main(String[] args) {
        Problem654 problem654 = new Problem654();
    }
}
