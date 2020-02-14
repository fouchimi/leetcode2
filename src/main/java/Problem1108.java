public class Problem1108 {
    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.') sb.append('[').append(ch).append(']');
            else sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1108 problem1108 = new Problem1108();
        System.out.println(problem1108.defangIPaddr("1.1.1.1"));
    }

}
