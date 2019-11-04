import java.util.*;

public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    private void combinationSum(int[] candidates, int index, int target, List<Integer> list,  List<List<Integer>> res) {
        if (index == candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                list.add(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem39 problem39 = new Problem39();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = problem39.combinationSum(candidates, 7);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
