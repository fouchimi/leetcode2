public class Problem415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        else if (num2 == null || num2.length() == 0) return num1;
        else {
            StringBuilder sb = new StringBuilder();
            int sum = 0, i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 && j >= 0) {
                sum += Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j));
                sb.insert(0, sum % 10);
                sum /= 10;
                i--;
                j--;
            }

            while (i >= 0) {
                sum += Character.getNumericValue(num1.charAt(i));
                sb.insert(0, sum % 10);
                sum /= 10;
                i--;
            }

            while (j >= 0) {
                sum += Character.getNumericValue(num2.charAt(j));
                sb.insert(0, sum % 10);
                sum /= 10;
                j--;
            }

            if (sum > 0) sb.insert(0, 1);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Problem415 problem415 = new Problem415();

    }
}
