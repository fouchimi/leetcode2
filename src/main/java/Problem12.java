
public class Problem12 {
    public String intToRoman(int num) {
        String[] dict = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]      {1000, 900, 500, 400,  100,  90,  50,   40,  10,   9,    5,   4,    1 };
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int i = 0;
            while (nums[i] > num) i++;
            result.append(dict[i]);
            num -= nums[i];
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        System.out.println(problem12.intToRoman(3));
        System.out.println(problem12.intToRoman(4));
        System.out.println(problem12.intToRoman(58));
        System.out.println(problem12.intToRoman(9));
        System.out.println(problem12.intToRoman(1994));
    }
}
