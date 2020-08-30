import java.util.*;

public class Problem987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<int[]>> tree = new TreeMap<>();
        computeTreeVT(root, 0, tree, 0);
        List<List<Integer>> result = new ArrayList<>();
        tree.forEach((k ,v) -> {
            List<Integer> temp = new ArrayList<>();
            while (!v.isEmpty()){
                temp.add(v.poll()[1]);
            }
            result.add(temp);
        });
        return result;
    }

    void computeTreeVT(TreeNode root, int vd, Map<Integer,PriorityQueue<int[]>> tree, int h ){
        if(root == null)
            return;
        if(!tree.containsKey(vd))
            tree.put(vd, new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));
        int[] t = {h, root.val};
        tree.get(vd).add(t);
        computeTreeVT(root.left, vd -1, tree, h+1);
        computeTreeVT(root.right, vd +1, tree, h+1);
    }
}
