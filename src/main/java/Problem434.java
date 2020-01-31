public class Problem434 {
    public int countSegments(String s) {
        int i = 0, N = s.length(), count = 0;
        while (i < N) {
            int prev = i;
            while (i < N && s.charAt(i) != ' ') i++;
            if(i > prev) count++;
            while (i < N && s.charAt(i) == ' ') i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem434 problem434 = new Problem434();
        System.out.println(problem434.countSegments("Hello, my name is John"));
        System.out.println(problem434.countSegments("                "));
    }
}
