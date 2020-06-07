public class Problem1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0, maxLen = 0, sum = 0;
        for(int j = 0; j < t.length(); j++){
            //at every index find sum
            sum += Math.abs(t.charAt(j) - s.charAt(j));
            while (sum > maxCost){
                //if not a valid window subtract ith from sum
                sum -= Math.abs(t.charAt(i) - s.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Problem1208 problem1208 = new Problem1208();
        System.out.println(problem1208.equalSubstring("abcd", "bcdf", 3));
        System.out.println(problem1208.equalSubstring("abcd", "cdef", 3));
        System.out.println(problem1208.equalSubstring("abcd", "acde", 0));
        System.out.println(problem1208.equalSubstring("abcd", "cdef", 1));
        System.out.println(problem1208.equalSubstring("pxezla", "loewbi", 25));
        System.out.println(problem1208.equalSubstring("abcd", "abcd", 0));
    }
}
