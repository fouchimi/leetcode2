import java.util.HashMap;
import java.util.Map;

public class Problem166 {

    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";
        if(denominator == 0) return "";

        boolean sign = (numerator < 0) ^ (denominator < 0);

        StringBuilder ans = new StringBuilder();

        long num = Math.abs(new Long(numerator));
        long den = Math.abs(new Long(denominator));

        if(sign) ans.append("-");

        ans.append(num / den);
        long remainder = (num % den) * 10;

        if(remainder != 0) ans.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }

            map.put(remainder, ans.length());
            ans.append(remainder / den);
            remainder = (remainder % den) * 10;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Problem166 problem166 = new Problem166();
        System.out.println(problem166.fractionToDecimal(4, 333));
        System.out.println(problem166.fractionToDecimal(2, 3));
        System.out.println(problem166.fractionToDecimal(1, 2));
        System.out.println(problem166.fractionToDecimal(1, 6));
        System.out.println(problem166.fractionToDecimal(1, 90));
    }
}
