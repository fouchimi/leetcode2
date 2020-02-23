import java.util.*;

public class Problem538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> list = bfs(root);
        helper(list);
        return root;
    }

    private List<TreeNode> bfs(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode top = queue.poll();
            nodeList.add(top);
            if (top.left != null) queue.offer(top.left);
            if (top.right != null) queue.offer(top.right);
        }

        return nodeList;
    }

    private Map<TreeNode, Integer> helper(List<TreeNode> list) {
        Map<TreeNode, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i).val;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                else if (list.get(j).val > list.get(i).val) sum += list.get(j).val;
            }
            map.put(list.get(i), sum);
        }

        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) entry.getKey().val = entry.getValue();
        return map;
    }



    public static void main(String[] args) {
        Problem538 problem538 = new Problem538();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        problem538.convertBST(root);
    }
}
