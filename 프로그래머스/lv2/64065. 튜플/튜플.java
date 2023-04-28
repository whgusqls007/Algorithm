import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] strs = s.replace("{", "").split("},");
        strs[strs.length - 1] = strs[strs.length - 1].replace("}", "");
        Arrays.sort(strs, (e1, e2) -> e1.length() - e2.length());

        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(strs[0]));

        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(strs[0]));

        for (int i = 1; i < strs.length; i++) {
            String[] str = strs[i].split(",");
            for(int j = 0; j < str.length; j++) {
                if(!set.contains(Integer.parseInt(str[j]))) {
                    set.add(Integer.parseInt(str[j]));
                    list.add(Integer.parseInt(str[j]));
                    break;
                }
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}