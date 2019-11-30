public class Problem67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a == null || b == null) return sb.toString();
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0;
        while (i >= 0 && j >= 0) {
            sum += Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j));
            sb.insert(0, sum % 2);
            sum /= 2;
            i--;
            j--;
        }

        while (i >= 0) {
            sum += Character.getNumericValue(a.charAt(i));
            sb.insert(0, sum % 2);
            sum /= 2;
            i--;
        }

        while(j >= 0) {
            sum += Character.getNumericValue(b.charAt(j));
            sb.insert(0, sum % 2);
            sum /= 2;
            j--;
        }
        if (sum  == 1) sb.insert(0, 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem67 problem67 = new Problem67();
        System.out.println(problem67.addBinary("1010", "1011"));
    }
}
