import java.util.*;

public class Problem811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] chunks = domain.split(" ");
            int val = Integer.parseInt(chunks[0]);
            String subdomain = chunks[1];
            int j = subdomain.length() - 1;
            while (j > 0) {
                if (subdomain.charAt(j) == '.') {
                    String key = subdomain.substring(j + 1);
                    map.put(key, map.getOrDefault(key, 0) + val);
                }
                j--;
            }
            map.put(subdomain, map.getOrDefault(subdomain, 0) + val);

        }

        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) res.add(map.get(key) + " " + key);

        return res;
    }

    public static void main(String[] args) {
        Problem811 problem811 = new Problem811();
        System.out.println(problem811.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(problem811.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
