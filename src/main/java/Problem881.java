import java.util.*;

public class Problem881 {
    public int numRescueBoats(int[] people, int limit) {
        int min = 0;
        Arrays.sort(people);
        for (int i = people.length - 1; i >= 0;) {
            int val = people[i];
            if (val >= limit) {
                min++;
                i--;
            } else {
                int sum = 0, j = i, steps = 0;
                while (j >= 0 && sum < limit) {
                    sum += people[j];
                    j--;
                    steps++;
                }
                if (sum <= limit) min++;
                else if (hasGCD(sum, limit)) min += sum / limit;
                else min += steps;
                i = j;
            }
        }

        return min;
    }

    private boolean hasGCD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a > 1;
    }

    public static void main(String[] args) {
        Problem881 problem881 = new Problem881();
        System.out.println(problem881.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(problem881.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(problem881.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(problem881.numRescueBoats(new int[]{2, 2}, 6));
        System.out.println(problem881.numRescueBoats(new int[]{3, 1, 7}, 7));
        System.out.println(problem881.numRescueBoats(new int[]{5, 1, 4, 2}, 6));
    }
}
