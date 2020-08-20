import java.util.Arrays;

public class Problem44 {
    public boolean isMatch(String s, String p) {
        int[][] cache = new int[s.length() + 1][p.length() + 1];
        for (int[] arr : cache) Arrays.fill(arr, -1);
        return helper(s, p, 0, 0, cache) == 1;
    }

    private int helper(String s, String p, int sIndex, int pIndex, int[][] cache) {
        if (sIndex == s.length() && pIndex == p.length()) return 1;
        if (sIndex == s.length()) {
            if (p.charAt(pIndex) == '*') {
                if (helper(s, p, sIndex, pIndex + 1, cache) == 1) {
                    cache[sIndex][pIndex] = 1;
                    return cache[sIndex][pIndex];
                }
            }
            return 0;
        }
        if (pIndex == p.length()) return 0;
        if (cache[sIndex][pIndex] != -1) return cache[sIndex][pIndex];
        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
            if (helper(s, p, sIndex + 1, pIndex + 1, cache) == 1) {
                cache[sIndex][pIndex] = 1;
                return cache[sIndex][pIndex];
            }
        } else if (p.charAt(pIndex) == '*') {
            if (helper(s, p, sIndex + 1, pIndex + 1, cache) == 1 ||
               helper(s, p, sIndex, pIndex + 1, cache) == 1 ||
               helper(s, p, sIndex + 1, pIndex, cache) == 1) {
                cache[sIndex][pIndex]  = 1;
                return cache[sIndex][pIndex];
            }
        }
        cache[sIndex][pIndex] = 0;
        return cache[sIndex][pIndex];
    }
}
