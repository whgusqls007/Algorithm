import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            makeKey(info[i].split(" "), map, 0, "");
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String s[] = query[i].replaceAll(" and ", "").split(" ");
            if (map.containsKey(s[0])) {
                answer[i] = binarySearch(Integer.parseInt(s[1]), map.get(s[0]));
            }
        }

        return answer;
    }

    public static int binarySearch(int score, List<Integer> list) {
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }

    public void makeKey(String[] strs, Map<String, List<Integer>> map, int index, String key) {
        if (index == 4) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.parseInt(strs[index]));
            return;
        }
        makeKey(strs, map, index + 1, key + "-");
        makeKey(strs, map, index + 1, key + strs[index]);
    }
}