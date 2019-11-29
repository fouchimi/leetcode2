public class Problem6 {

    public String convert(String s, int numRows) {
        if (s == null) return null;
        char[][] matrix = new char[numRows][s.length()];
        int k = 0, top = 0, bottom = numRows - 1, col = 0;
        while (k < s.length()) {
            for (int i = top; i <= bottom; i++) {
                if (k < s.length()) {
                    matrix[i][col] = s.charAt(k);
                    k++;
                }
            }
            bottom--;
            for (int j = bottom; j > top; j--) {
                if (k < s.length()) {
                    matrix[j][++col] = s.charAt(k);
                    k++;
                }
            }
            col++;
            bottom = numRows - 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char ch = matrix[i][j];
                if (ch != '\u0000') sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        System.out.println(problem6.convert("PAYPALISHIRING", 1));
    }
}
