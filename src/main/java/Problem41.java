import java.util.*;

public class Problem41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num <= 0) continue;
            set.add(num);
        }
        if (set.isEmpty()) return 1;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int i = 0;
        while (i < list.size() && list.get(i) <= 0) i++;
        int count = 1;
        for(int j = i; j < list.size(); j++) {
            if (list.get(j) > count) return count;
            count++;
        }
        return list.get(list.size() - 1) == Integer.MAX_VALUE ? Integer.MAX_VALUE : count;
    }

    public static void main(String[] args) {
        Problem41 problem41 = new Problem41();
        int[] nums = {1,1};
        System.out.println(problem41.firstMissingPositive(nums));
    }
}
