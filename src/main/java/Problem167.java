import java.util.HashMap;
import java.util.Map;

public class Problem167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[]{0};
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i + 1;
                break;
            }
            map.put(numbers[i], i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem167 problem167 = new Problem167();
        int[] res = problem167.twoSum(new int[]{2,7,11,15}, 9);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
