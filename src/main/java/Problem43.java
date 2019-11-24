public class Problem43 {
    public String multiply(String num1, String num2) {
        if ((num1.length() == 1 && num1.charAt(0) == '0') || num2.length() == 1 && num2.charAt(0) == '0') return "0";
        String ans = "";
        int k = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            ans = getProduct(num1, num2.charAt(i), ans, k);
            k++;
        }
        return ans;
    }

    private String getProduct (String num1, char ch, String ans, int k) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int j = num1.length() - 1; j >= 0; j--) {
            sum += Character.getNumericValue(ch) * Character.getNumericValue(num1.charAt(j));
            sb.insert(0, sum % 10);
            sum /= 10;
        }
        if (sum > 0) sb.insert(0, sum);

        if (ans.length() == 0) return sb.toString();
        else {
            while (k > 0) {
                sb.append(0);
                k--;
            }
            String currentSum = sb.toString();
            int i = ans.length() - 1, j = currentSum.length() - 1;
            StringBuilder res = new StringBuilder();
            sum = 0;
            while (i >= 0 && j >= 0) {
                sum += Character.getNumericValue(ans.charAt(i)) + Character.getNumericValue(currentSum.charAt(j));
                res.insert(0, sum % 10);
                sum /= 10;
                j--;
                i--;
            }

            while (i >= 0) {
                sum += Character.getNumericValue(ans.charAt(i));
                res.insert(0, sum % 10);
                sum /= 10;
                i--;
            }

            while (j >= 0) {
                sum += Character.getNumericValue(currentSum.charAt(j));
                res.insert(0, sum % 10);
                sum /= 10;
                j--;
            }

            if (sum > 0) res.insert(0, sum);

            return res.toString();
        }
    }

    public static void main(String[] args){
        Problem43 problem43 = new Problem43();
        System.out.println(problem43.multiply("2", "3"));
        System.out.println(problem43.multiply("123", "456"));
        System.out.println(problem43.multiply("88", "567"));
    }
}
