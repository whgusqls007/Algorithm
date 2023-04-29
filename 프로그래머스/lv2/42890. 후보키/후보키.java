import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();

    public int solution(String[][] relation) {

        for (int i = 0; i < relation[0].length; i++) {
            dfs(0, "", i + 1, relation, 0);
        }

        int answer = set.size();

        return answer;
    }

    public void dfs(int depth, String index, int n, String[][] relation, int start) {
        if (depth == n) {
            Set<String> check = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < index.length(); j++) {
                    int k = (int) index.charAt(j) - '0';
                    sb.append(relation[i][k] + " ");
                }
                if (!check.contains(sb.toString())) {
                    check.add(sb.toString());
                } else {
                    return;
                }
            }
            set.add(index);
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            if (!keyCheck(index + i, "", 0))
                continue;
            dfs(depth + 1, index + i, n, relation, i + 1);
        }
    }

    public boolean keyCheck(String key, String checkKey, int start) {
        boolean rv = true;

        if (checkKey.length() > 0) {
            if (set.contains(checkKey)) {
                return false;
            }
        }

        for (int i = start; i < key.length(); i++) {
            if (!keyCheck(key, checkKey + key.charAt(i), i + 1)) {
                return false;
            }
        }

        return rv;
    }
}