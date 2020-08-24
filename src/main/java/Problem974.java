import java.util.LinkedHashMap;
import java.util.Map;

public class Problem974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int count = 0,  sum = 0;
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            sum = sum % k;
            if (sum < 0) sum += k;
            if (map.containsKey(sum)) count += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Problem974 problem974 = new Problem974();
        System.out.println(problem974.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(problem974.subarraysDivByK(new int[]{5}, 9));
    }
}
