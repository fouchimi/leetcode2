import java.util.*;

public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        int[] need = new int[128], window = new int[128];

        for (int i = 0; i < p.length(); i++)
            need[p.charAt(i)]++;

        int l = 0, r = 0, count = 0;

        while (r < s.length()){
            char cur = s.charAt(r++);
            if (need[cur] > 0){
                window[cur]++;
                if (need[cur] >= window[cur])
                    count++;
            }

            while (count == p.length()) {
                if (r - l == p.length()) ans.add(l);
                char ch = s.charAt(l++);
                if (need[ch] > 0){
                    window[ch]--;
                    if (need[ch] > window[ch])
                        count--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Problem438 problem438 = new Problem438();
        System.out.println(problem438.findAnagrams("cbaebabacd", "abc"));
        System.out.println(problem438.findAnagrams("abab", "ab"));
    }
}
