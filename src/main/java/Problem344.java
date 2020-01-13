public class Problem344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    public static void main(String[] args) {
        Problem344 problem344 = new Problem344();
        problem344.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        problem344.reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }
}
