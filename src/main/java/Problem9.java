public class Problem9 {

    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        for (int i = 0, j = value.length()-1; i < j; i++, j--) {
            if (value.charAt(i) != value.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem9 problem9 = new Problem9();
        System.out.println(problem9.isPalindrome(-121));
        System.out.println(problem9.isPalindrome(10));
        System.out.println(problem9.isPalindrome(121));
    }
}
