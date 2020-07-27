import java.util.*;

public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[nums.length];
        int max = -1, idx = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        map.put(i, j);
                    }
                }
            }
            if (dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }

        if (idx >= 0) res.add(nums[idx]);

        while (map.containsKey(idx)) {
            idx = map.get(idx);
            res.add(nums[idx]);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem368 problem368 = new Problem368();
//        List<Integer> list = problem368.largestDivisibleSubset(new int[]{1, 2, 3});
//        System.out.println(list);
//        List<Integer> list = problem368.largestDivisibleSubset(new int[]{1, 2, 4, 8});
//        System.out.println(list);
//        list = problem368.largestDivisibleSubset(new int[]{1,2,3,4,6,24});
//        System.out.println(list);
        List<Integer> list = problem368.largestDivisibleSubset(new int[]{5,9,18,54,108,540,90,180,360,720});
        System.out.println(list);
    }
}
