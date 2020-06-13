public class Problem984 {

    public String strWithout3a3b(int A, int B) {

        StringBuilder sb = new StringBuilder();
        boolean flag = A > B;

        while (A > 0 || B > 0) {
            if (flag) {
                sb.append("a");
                A--;
                if (A > B) {
                    sb.append("a");
                    A--;
                }
                flag = false;
            }
            else {
                sb.append("b");
                B--;
                if (B > A) {
                    sb.append("b");
                    B--;
                }
                flag = true;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Problem984 problem984 = new Problem984();
        System.out.println(problem984.strWithout3a3b(1, 2));
        System.out.println(problem984.strWithout3a3b(4, 1));
        System.out.println(problem984.strWithout3a3b(2, 5));
        System.out.println(problem984.strWithout3a3b(2, 6));
        System.out.println(problem984.strWithout3a3b(4, 4));
        System.out.println(problem984.strWithout3a3b(6, 6));
    }
}
