public class Problem1456 {
    public int maxVowels(String s, int k) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int windowEnd = 0, start = 0, max = 0, sum = 0;
        for (; windowEnd < s.length();) {
            while (windowEnd < s.length() && windowEnd - start < k) {
                if (isVowel(vowels, s.charAt(windowEnd))) sum++;;
                windowEnd++;
            }
            max = Math.max(max, sum);
            while (windowEnd - start == k) {
                if (isVowel(vowels, s.charAt(start))) sum--;
                start++;
            }
        }
        return max;
    }

    private static boolean isVowel(char[] vowels, char ch) {
        for (char c : vowels) {
            if (c == ch) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem1456 problem1456 = new Problem1456();
        System.out.println(problem1456.maxVowels("abciiidef", 3));
        System.out.println(problem1456.maxVowels("weallloveyou", 7));
    }
}
