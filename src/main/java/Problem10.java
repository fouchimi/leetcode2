import java.util.Arrays;

public class Problem10 {

    public boolean isMatch(String s, String p) {
        if(s == null && p == null || s.length() == 0 && p.length() == 0) return true;
        return helper(s,p,0,0);
    }

    private boolean helper(String s, String p, int sIndex, int pIndex){
        // base case - reached end of pattern, why we're not doing if(pIndex >= p.length() && sIndex >= s.length()), because end of pattern
        // meaning we have to return a result. If we add those two conditions together then we will not be returning any result and will cause out of bound exception
        if(pIndex == p.length()) {
            return sIndex == s.length();
        }

        // if next pattern char is '*', example "aaab", "a*b"
        if(pIndex < p.length()-1 && p.charAt(pIndex+1) == '*'){
            // we have two choices, zero char match, meaning no change in the actual string index but pattern index will jump after * character
            if(helper(s,p,sIndex,pIndex+2)) return true;
            // match multiple time prev character, as * can match multiple times the previous character
            if(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')){
                if(helper(s,p,sIndex+1,pIndex)) return true;
            }
        }else if(sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex))){
            if(helper(s,p,sIndex+1,pIndex+1)) return true;
        }

        return false;
    }


    public boolean isMatchMemoized(String s, String p) {
        if (s == null && p == null | s.length() == 0 && p.length() == 0) return true;
        int[][] cache = new int[s.length() + 1][p.length() + 1];
        for (int[] ints : cache) Arrays.fill(ints, -1);
        return helperUtil(s, p, 0, 0, cache) == 1;
    }

    private int helperUtil(String s, String p, int sIndex, int pIndex, int[][] cache) {
        if (pIndex == p.length()) {
            return sIndex == s.length() ? 1 : 0;
        }
        if (cache[sIndex][pIndex] != -1) return cache[sIndex][pIndex];

        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            if (helperUtil(s, p, sIndex, pIndex + 2, cache) == 1) {
                cache[sIndex][pIndex] = 1;
                return cache[sIndex][pIndex];
            }
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                if (helperUtil(s, p, sIndex + 1, pIndex, cache) == 1) {
                    cache[sIndex][pIndex] = 1;
                    return cache[sIndex][pIndex];
                }
            }
        } else if (sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex))) {
            if (helperUtil(s, p, sIndex + 1, pIndex + 1, cache) == 1) {
                cache[sIndex][pIndex] = 1;
                return cache[sIndex][pIndex];
            }
        }
        cache[sIndex][pIndex] = 0;
        return cache[sIndex][pIndex] = 0;
    }

    public static void main(String[] args) {
        Problem10 problem10 = new Problem10();
        System.out.println(problem10.isMatch("aa", "a"));
        System.out.println(problem10.isMatch("aa", "a*"));
        System.out.println(problem10.isMatch("ab", ".*"));
        System.out.println(problem10.isMatch("aab", "c*a*b"));
        System.out.println(problem10.isMatch("mississippi", "mis*is*p*."));
    }
}
