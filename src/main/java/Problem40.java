import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Util(candidates, target, new ArrayList<>(), resultList, 0);
        return resultList;
    }

    private void combinationSum2Util(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int index) {
        if (index > candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            if (i > index && candidates[i - 1] == candidates[i]) continue;
            list.add(candidates[i]);
            combinationSum2Util(candidates, target - candidates[i], list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem40 problem40 = new Problem40();
        List<List<Integer>> res = problem40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
