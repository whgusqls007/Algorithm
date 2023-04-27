import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    int[] maximum;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        int max = Arrays.stream(course).max().getAsInt();
        maximum = new int[max + 1];
        map.clear();
        for (int j = 0; j < orders.length; j++) {
            char[] menu = orders[j].toCharArray();
            Arrays.sort(menu);
            dfs(menu, 0, "", max);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            for (String key : map.keySet()) {
                if (key.length() == course[i] && map.get(key) == maximum[course[i]] && maximum[course[i]] >= 2) {
                    list.add(key);
                }
            }
        }

        Collections.sort(list);

        answer = list.toArray(answer);
        
        return answer;
    }

    public void dfs(char[] menu, int index, String set, int n) {
        if (2 <= set.length() && set.length() <= n) {
            int c = map.getOrDefault(set, 0);
            map.put(set, c + 1);
            maximum[set.length()] = Math.max(maximum[set.length()], c + 1);
            if (set.length() == n) {
                return;
            }
        }

        for (int i = index; i < menu.length; i++) {
            dfs(menu, i + 1, set + menu[i], n);
        }
    }
}