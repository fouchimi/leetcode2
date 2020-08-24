import java.util.ArrayList;
import java.util.List;

public class Problem282 {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, num, target);
        return result;
    }
    private void dfs(List<String> result, String curStr, long curSum, long curHead, String curNum, long target){
        if (curNum.length() == 0 && target - curSum - curHead == 0) {
            result.add(curStr);
            return;
        }
        for (int i = 1; i <= curNum.length(); i++){
            String strNum = curNum.substring(0, i);
            long lNum = Long.parseLong(strNum);
            if (lNum > Integer.MAX_VALUE || curHead > Integer.MAX_VALUE) break;
            if (curStr.length() == 0) dfs(result, strNum, 0, lNum, curNum.substring(i), target);
            else {
                dfs(result, curStr + "*" + strNum, curSum, curHead * lNum, curNum.substring(i), target);
                dfs(result, curStr + "+" + strNum, curSum + curHead, lNum, curNum.substring(i), target);
                dfs(result, curStr + "-" + strNum, curSum + curHead, -lNum, curNum.substring(i), target);
            }
            if (lNum == 0) break;
        }
    }

    public static void main(String[] args) {
        Problem282 problem282 = new Problem282();
        System.out.println(problem282.addOperators("123", 6));
        System.out.println(problem282.addOperators("232", 8));
    }
}
