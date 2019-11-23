public class Problem28 {
    public int strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        return index < 0 ? -1 : index;
    }

    public static void main(String[] args) {
        Problem28 problem28 = new Problem28();
        System.out.println(problem28.strStr("hello", "ll"));
        System.out.println(problem28.strStr("aaaaa", "bba"));
    }
}
