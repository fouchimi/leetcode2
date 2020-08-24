public class Problem306 {
    public boolean isAdditiveNumber(String s) {
        if (s == null || s.length() < 3) return false;
        for (int l1 = 1; l1 <= s.length() / 2; ++l1) {
            if (l1 > 1 && s.charAt(0) == '0') break;
            // bug - 2 => the length restriction ensures there will the third to be validated;
            for (int l2 = 1; l2 < s.length() - l1; ++l2) {
                if (l2 > 1 && s.charAt(l1) == '0') break;
                Long num1 = Long.valueOf(s.substring(0, l1));
                Long num2 = Long.valueOf(s.substring(l1, l1 + l2));
                if (isAdditive(s.substring(l1 + l2), num1, num2)) return true;
            }
        }
        return false;
    }

    private boolean isAdditive(String s, Long num1, Long num2) {
        if (s.isEmpty()) return true;
        String num3Str = String.valueOf(num1 + num2);
        if (!s.startsWith(num3Str)) return false;
        return isAdditive(s.substring(num3Str.length()), num2, num1 + num2);
    }

    public static void main(String[] args) {
        Problem306 problem306 = new Problem306();
        System.out.println(problem306.isAdditiveNumber("112358"));
        System.out.println(problem306.isAdditiveNumber("199100199"));
        System.out.println(problem306.isAdditiveNumber("0235813"));
        System.out.println(problem306.isAdditiveNumber("000"));
        System.out.println(problem306.isAdditiveNumber("12122436"));
    }
}
