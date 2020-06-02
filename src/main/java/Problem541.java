public class Problem541 {
    public String reverseStr(String s, int k) {
        int start = 0, end = k, j = 0;
        StringBuilder sb = new StringBuilder();

        if (s.length() < k) {
            int i = 0;
            while (i < s.length()) {
                sb.insert(0, s.charAt(i));
                i++;
            }
        }

        while (start < end && end <= s.length()) {
            String prefix = s.substring(start, end);
            StringBuilder tempSb = new StringBuilder();
            if (j % 2 == 0) {
                for (int i = prefix.length() - 1; i >= 0; i--) tempSb.append(prefix.charAt(i));
            }
            else {
                for (int i = 0; i < prefix.length(); i++) tempSb.append(prefix.charAt(i));
            }
            sb.append(tempSb.toString());
            start = end;
            end += k;
            j++;
        }

        StringBuilder suffix = new StringBuilder();
        if (sb.toString().length() < s.length()) {
            while (start < s.length()) {
                suffix.insert(0, s.charAt(start));
                start++;
            }
            sb.append(suffix.toString());
        }
        return sb.toString();
    }

    public  static void main(String[] args) {
        Problem541 problem541 = new Problem541();
        System.out.println(problem541.reverseStr("abcdefg", 2));
        System.out.println(problem541.reverseStr("abcdefg", 8));
        System.out.println(problem541.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }
}
