public class Problem541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int N = 2*k;
        while (s.length() >= N) {
            String prefix = s.substring(0, k);
            sb.append(reverse(prefix));
            String suffix = s.substring(k, N);
            sb.append(suffix);
            s = s.substring(N);
        }
        if (s.length() < k) sb.append(s);
        else {
            String p = s.substring(0, k);
            sb.append(reverse(p));
            s = s.substring(k);
            if (s.length() > 0) sb.append(s);
        }
        return sb.toString();
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) sb.append(str.charAt(i));
        return sb.toString();
    }

    public  static void main(String[] args) {
        Problem541 problem541 = new Problem541();
        System.out.println(problem541.reverseStr("abcdefg", 2));
        System.out.println(problem541.reverseStr("abcdefg", 8));
        System.out.println(problem541.reverseStr("abcdefg", 4));
        System.out.println(problem541.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }
}
