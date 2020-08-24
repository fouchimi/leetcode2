import java.util.*;

public class Problem881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            int sum = people[l] + people[r];
            ans++;
            if (sum <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
        }
        if (l == r) ans++;
        return ans;
    }

    public static void main(String[] args) {
        Problem881 problem881 = new Problem881();
        System.out.println(problem881.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(problem881.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(problem881.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(problem881.numRescueBoats(new int[]{2, 2}, 6));
        System.out.println(problem881.numRescueBoats(new int[]{3, 1, 7}, 7));
        System.out.println(problem881.numRescueBoats(new int[]{5, 1, 4, 2}, 6));
        System.out.println(problem881.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(problem881.numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6));
        System.out.println(problem881.numRescueBoats(new int[]{3, 8, 7, 1, 4}, 9));
        System.out.println(problem881.numRescueBoats(new int[]{5, 1, 7, 4, 2, 4}, 7));
        // 7, 5, 4, 4, 2, 1
    }
}
