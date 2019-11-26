import java.util.ArrayList;
import java.util.List;

public class Problem93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(String address, int index, List<String> list,  List<String> res) {
        if (list.size() > 4) return;
        if (index == address.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) sb.append(list.get(i)).append('.');
            String newAddress = sb.toString();
            res.add(newAddress.substring(0, newAddress.length()-1));
            return;
        }

        for (int i = index; i < address.length(); i++) {
            if (i + 1 <= address.length()) {
                String value = address.substring(index, i + 1);
                if (value.length() > 3 || Integer.parseInt(value) > 255) break;
                if (value.length() > 1 && value.charAt(0) == '0') break;
                list.add(value);
                helper(address, i + 1, list, res);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Problem93 problem93 = new Problem93();
        System.out.println(problem93.restoreIpAddresses("0000"));
    }
}
