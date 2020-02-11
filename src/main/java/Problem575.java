import java.util.HashMap;
import java.util.Map;

public class Problem575 {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        int N = candies.length;
        for (int i = 0; i < candies.length; i++) map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        int count = map.size();
        if (count > N / 2) return N / 2;
        else return count;
    }

    public static void main(String[] args) {
        Problem575 problem575 = new Problem575();
        System.out.println(problem575.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(problem575.distributeCandies(new int[]{1, 1, 2, 3}));
        System.out.println(problem575.distributeCandies(new int[]{1, 11}));
    }
}
