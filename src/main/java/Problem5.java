public class Problem5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left , int right) {
        if (s == null || left > right) return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
//        System.out.println(problem5.longestPalindrome("babad"));
//        System.out.println(problem5.longestPalindrome("cbbd"));
        System.out.println(problem5.longestPalindrome("abcba"));
        System.out.println(problem5.longestPalindrome("racecar"));
        System.out.println(problem5.longestPalindrome("aacbbcaa"));
    }
}
