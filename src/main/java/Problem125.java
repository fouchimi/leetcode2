public class Problem125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) sb.append(ch);
        }
        s = sb.toString();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem125 problem125 = new Problem125();
        System.out.println(problem125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(problem125.isPalindrome("race a car"));
        System.out.println(problem125.isPalindrome("0P"));
    }
}
