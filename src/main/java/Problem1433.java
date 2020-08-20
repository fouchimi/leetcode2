import java.util.Arrays;

public class Problem1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        int n = s1.length();
        boolean ans1 = true, ans2 = true;
        for(int i = 0; i < n; i++){
            if (s1Chars[i] < s2Chars[i]) ans1=false;
            if (s2Chars[i] < s1Chars[i]) ans2=false;
        }
        return ans1 || ans2;
    }

    public static void main(String[] args) {
        Problem1433 problem1433 = new Problem1433();
        System.out.println(problem1433.checkIfCanBreak("abc", "xya"));
        System.out.println(problem1433.checkIfCanBreak("abe", "acd"));
        System.out.println(problem1433.checkIfCanBreak("leetcodee", "interview"));
    }
}
