import java.util.LinkedHashMap;
import java.util.Map;

public class Problem1410 {
    public String entityParser(String text) {
        Map<String, String> dict = new LinkedHashMap<>();
        dict.put("&amp;", "&");
        dict.put("&quot;", "\"");
        dict.put("&apos;", "'");
        dict.put("&gt;", ">");
        dict.put("&lt;", "<");
        dict.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length();) {
            if (text.charAt(i) == '&') {
                int j = i;
                while (j < text.length() && text.charAt(j) != ';') j++;
                String substr = text.substring(i, ++j);
                if (substr.length() > 0) {
                    if (dict.get(substr) != null) {
                        if (substr.equals("&quot;")) sb.append('"');
                        else sb.append(dict.get(substr));
                    }
                    else sb.append(substr);
                }
                i = j;
            } else {
                sb.append(text.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1410 problem1410 = new Problem1410();
        //System.out.println(problem1410.entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(problem1410.entityParser("and I quote: &quot;...&quot;"));
        System.out.println(problem1410.entityParser("Stay home! Practice on Leetcode :)"));
        System.out.println(problem1410.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
        System.out.println(problem1410.entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }
}
