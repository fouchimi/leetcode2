public class Problem58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] strs = s.split(" ");
        return strs.length == 0 ? 0 : strs[strs.length - 1].length();
    }

    public static void main(String[] args) {
        Problem58 problem58 = new Problem58();
        System.out.println(problem58.lengthOfLastWord(" "));
    }
}
