import java.util.*;

public class Problem739 {
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] res = new int[N];
        int i = 0, j = 1;
        while (i < N && j < N) {
            while (j < N) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    i++;
                    j++;
                }
                else {
                    while (j < N && T[j] <= T[i]) j++;
                    if (j < N) {
                        res[i] = j - i;
                        ++i;
                        j = i;
                    } else j = ++i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem739 problem739 = new Problem739();
        int[] ans = problem739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        //int[] ans = problem739.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        //int[] ans = problem739.dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78});
        for(int temp : ans) {
            System.out.print(temp + " ");
        }
    }
}
