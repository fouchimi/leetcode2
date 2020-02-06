
public class Problem227 {
    public int calculate(String s) {
        int res = 0, tmp = 0, num = 0, i = 0;
        char op = '#';
        boolean neg = false;
        s += "+";
        while (i < s.length()){
            char c = s.charAt(i);
            i++;
            if (Character.isDigit(c)) {
                int d = Character.getNumericValue(c); //can not use Integer.valueOf()
                num *= 10;
                num += d;
            } else if (c == '+' || c == '-' || c == '/' || c == '*'){
                if (op == '*') tmp *= num;
                else if (op == '/' && num != 0) tmp /= num;
                else if (op == '#') tmp += num;
                num = 0;
                if (c == '+' || c == '-'){
                    tmp = neg ? -tmp : tmp;
                    res += tmp;
                    neg = c == '-';
                    tmp = 0;
                    op = '#';
                } else op = c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem227 problem227 = new Problem227();
        System.out.println(problem227.calculate("3+2*2"));
        System.out.println(problem227.calculate("3/2"));
        System.out.println(problem227.calculate(" 3+5 / 2 "));
        System.out.println(problem227.calculate("1-1+1"));
        System.out.println(problem227.calculate("0-2147483647"));
    }
}
