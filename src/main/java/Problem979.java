public class Problem979 {

    int move;
    public int distributeCoins(TreeNode root) {
        move = 0;
        coins(root);
        return move;
    }

    public int coins(TreeNode root) {
        if (root == null)
            return 0;
        int coin = root.val - 1;
        coin += coins(root.left);
        coin += coins(root.right);
        move += Math.abs(coin);
        return coin;
    }

    public static void main(String[] args) {
        Problem979 problem979 = new Problem979();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(3);
        System.out.println(problem979.distributeCoins(root));
    }
}
