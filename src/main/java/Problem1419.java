
public class Problem1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {

        int n = croakOfFrogs.length();
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int ans = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (croakOfFrogs.charAt(i) == 'c') {
                c++;
                count++;
            } else if (croakOfFrogs.charAt(i) == 'r') {
                r++;
            } else if (croakOfFrogs.charAt(i) == 'o') {
                o++;
            } else if (croakOfFrogs.charAt(i) == 'a') {
                a++;
            } else if (croakOfFrogs.charAt(i) == 'k') {
                k++;
                count--;
            }
            ans = Math.max(ans, count);
            if (c < r || r < o || o < a || a < k)
                return -1;
        }

        if (count == 0 && c == r && r == o && o == a && a == k)
            return ans;

        return -1;
    }

    public static void main(String[] args) {
        Problem1419 problem1419 = new Problem1419();
        System.out.println(problem1419.minNumberOfFrogs("croakcroak"));
        System.out.println(problem1419.minNumberOfFrogs("crcoakroak"));
        System.out.println(problem1419.minNumberOfFrogs("croakcrook"));
        System.out.println(problem1419.minNumberOfFrogs("croakcroa"));
        System.out.println(problem1419.minNumberOfFrogs("cccrorakrcoakorakoak"));
    }
}
