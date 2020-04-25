public class Problem925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                int k = j;
                while (i - 1 >= 0 && j < typed.length() && typed.charAt(j) == name.charAt(i - 1)) j++;
                if (k == j) return false;
            }
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(i - 1)) break;
            j++;
        }
        return i == name.length() && j == typed.length();
    }

    public static void main(String[] args) {
        Problem925 problem925 = new Problem925();
//        System.out.println(problem925.isLongPressedName("alex", "aaleex"));
//        System.out.println(problem925.isLongPressedName("saeed", "ssaaedd"));
//        System.out.println(problem925.isLongPressedName("leelee", "lleeelee"));
//        System.out.println(problem925.isLongPressedName("laiden", "laiden"));
//        System.out.println(problem925.isLongPressedName("pyplrz" , "ppyypllr"));
        System.out.println(problem925.isLongPressedName("vtkgn", "vttkgnn"));
    }
}
