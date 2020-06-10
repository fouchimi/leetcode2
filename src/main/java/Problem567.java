
public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        for (int end = 0; end + len <= s2.length(); ) {
            if (isAnagram(s1, s2.substring(end, end + len))) return true;
            else end++;
        }
        return false;
    }

    private boolean isAnagram (String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        char[] count = new char[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        for (int cnt : count)
            if (cnt != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Problem567 problem567 = new Problem567();
//        System.out.println(problem567.checkInclusion("ab", "eidbaooo"));
//        System.out.println(problem567.checkInclusion("ab", "eidbooobaooo"));
//        System.out.println(problem567.checkInclusion("ab", "eidboaoo"));
//        System.out.println(problem567.checkInclusion("hello", "ooolleoooleh"));
        System.out.println(problem567.checkInclusion("adc", "dcda"));
    }
}
