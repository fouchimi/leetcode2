import java.util.Arrays;

public class Problem179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (first, second) -> {
            String f = first + second;
            String s = second + first;
            return s.compareTo(f);
        });
        StringBuilder sb = new StringBuilder();
        int countZeros = 0;
        for (String val : strs) {
            if (val.equals("0")) countZeros++;
            sb.append(val);
        }
        return countZeros == strs.length ? "0" : sb.toString();
    }

    public static void main(String[] args) {
       Problem179 problem179 = new Problem179();
       System.out.println(problem179.largestNumber(new int[]{10, 2}));
       System.out.println(problem179.largestNumber(new int[]{3, 30, 34, 5, 9}));
       System.out.println(problem179.largestNumber(new int[]{121, 12}));
        System.out.println(problem179.largestNumber(new int[]{128, 12}));
    }
}
