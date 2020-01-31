
public class Problem8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int i = 0, N = str.length();
        //Escaping spaces
        while (i < N && str.charAt(i) == ' ') i++;
        // Check sign
        int sign = 1;
        if (i < N && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        if (i < N && !Character.isDigit(str.charAt(i))) return 0;

        StringBuilder sb = new StringBuilder();
        while (i < N && Character.isDigit(str.charAt(i))) {
            sb.append(str.charAt(i));
            i++;
        }

        long result = 0;
        String sbStr = sb.toString();
        for (int j = 0; j < sbStr.length(); j++) {
            if (result > Integer.MAX_VALUE ) {
                if (sign < 0) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            result = 10 * result + Character.getNumericValue(sbStr.charAt(j));
        }
        if (result > Integer.MAX_VALUE) {
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (sign == -1) result = -result;
        return sbStr.length() == 0 ? 0 : (int) result;
    }

    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        System.out.println(problem8.myAtoi("+"));
        System.out.println(problem8.myAtoi("42"));
        System.out.println(problem8.myAtoi("-42"));
        System.out.println(problem8.myAtoi("4193 with words"));
        System.out.println(problem8.myAtoi("words and 987"));
        System.out.println(problem8.myAtoi("-91283472332"));
        System.out.println(problem8.myAtoi("9223372036854775808"));
        System.out.println(problem8.myAtoi("2147483648"));
        System.out.println(problem8.myAtoi("-2147483649"));
    }
}
