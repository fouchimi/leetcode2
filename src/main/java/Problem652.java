import java.util.*;

public class Problem652 {
    Map<Integer, Integer> count;
    Map<String, Integer> map;
    List<TreeNode> res;
    int globalId;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        map = new HashMap<>();
        res = new ArrayList<>();
        globalId = 1;
        postorderTraverse(root);
        return res;
    }
    public int postorderTraverse(TreeNode node) {
        if(node == null) return 0;
        String serial = node.val + "," + postorderTraverse(node.left) + "," + postorderTraverse(node.right);
        int uniqueId = map.computeIfAbsent(serial, x->globalId++); //get/create a uniqueId; computeIfAbsent only compute if key doesn't exist
        count.put(uniqueId, count.getOrDefault(uniqueId, 0) + 1);
        if (count.get(uniqueId) == 2){
            res.add(node);
        }
        return uniqueId;
    }

    public static void main(String[] args) {
        Problem652 problem652 = new Problem652();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(4);
//        root.right.left.left = new TreeNode(4);
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.left.left.right = new TreeNode(0);
        List<TreeNode> duplicateList = problem652.findDuplicateSubtrees(root);
        duplicateList.forEach(x -> System.out.print(x.val + " "));
    }
}
