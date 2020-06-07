import java.util.HashMap;

public class Problem560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) { // if we have already seen this sum
                count += map.get(sum - k); // add the number of times we have seen it to our result
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Problem560 problem560 = new Problem560();
        System.out.println(problem560.subarraySum(new int[]{1, 1}, 2));
        System.out.println(problem560.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(problem560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(problem560.subarraySum(new int[]{100, 1, 2, 3, 4}, 6));
        System.out.println(problem560.subarraySum(new int[]{1}, 0));
        System.out.println(problem560.subarraySum(new int[]{100, 1, 2, 3, 4}, 3));
    }
}
