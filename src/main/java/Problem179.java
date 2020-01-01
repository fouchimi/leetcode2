import java.util.Arrays;

public class Problem179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (first, second) -> {
            String f = first + second;
            String s = second + first;
            int fValue = Integer.parseInt(f);
            int sValue = Integer.parseInt(s);
            if (fValue > sValue) return -1;
            else if (fValue < sValue) return 1;
            else return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (String val : strs) sb.append(val);
        return sb.toString();
    }

    public static void main(String[] args) {
       Problem179 problem179 = new Problem179();
       System.out.println(problem179.largestNumber(new int[]{10, 2}));
       System.out.println(problem179.largestNumber(new int[]{3, 30, 34, 5, 9}));
       System.out.println(problem179.largestNumber(new int[]{121, 12}));
        System.out.println(problem179.largestNumber(new int[]{128, 12}));
    }
}
