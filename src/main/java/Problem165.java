import java.util.ArrayList;
import java.util.List;

public class Problem165 {
    public int compareVersion(String version1, String version2) {
        List<Integer> firstList = cleanVersion(version1);
        List<Integer> secondList = cleanVersion(version2);
        int i = 0, j = 0;
        for (; i < firstList.size() && j < secondList.size(); i++, j++) {
            if (firstList.get(i) < secondList.get(j)) return -1;
            else if (firstList.get(i) > secondList.get(j)) return 1;
        }
        while (i < firstList.size()) {
            if (firstList.get(i) > 0) return 1;
            i++;
        }

        while (j < secondList.size()) {
            if (secondList.get(j) > 0) return -1;
            j++;
        }

        return 0;
    }

    private List<Integer> cleanVersion(String version) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < version.length()) {
            int j = i;
            while (j  < version.length() && version.charAt(j) != '.') j++;
            String subStr = version.substring(i, j);
            if (!subStr.isEmpty()) list.add(Integer.parseInt(subStr));
            i = j + 1;
        }
        return list;
    }

    public static void main(String[] args) {
        Problem165 problem165 = new Problem165();
        System.out.println(problem165.compareVersion("0.1", "1.1"));
        System.out.println(problem165.compareVersion("1.0.1", "1"));
        System.out.println(problem165.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(problem165.compareVersion("1.01", "1.001"));
        System.out.println(problem165.compareVersion("1.0", "1.0.0"));
        System.out.println(problem165.compareVersion("0.1", "1.0"));

    }
}
