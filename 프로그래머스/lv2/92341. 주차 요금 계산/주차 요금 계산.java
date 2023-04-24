import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] tmp = records[i].split(" ");
            int time = getTime(tmp[0]);
            int carNum = Integer.parseInt(tmp[1]);
            String inOut = tmp[2];

            if (inOut.equals("IN")) {
                map1.put(carNum, time);
            } else {
                int preTime = map1.get(carNum);
                map2.put(carNum, map2.getOrDefault(carNum, 0) + (time - preTime));
                map1.remove(carNum);
            }
        }

        if (!map1.isEmpty()) {
            for (Integer key : map1.keySet()) {
                map2.put(key, map2.getOrDefault(key, 0) + (1439 - map1.get(key)));
            }
        }

        int[][] result = new int[map2.size()][2];

        int index = 0;
        for (Integer key : map2.keySet()) {
            int time = map2.get(key);
            time = time - fees[0];
            int fee = fees[1];
            if (time > 0) {
                fee += (int) Math.ceil((double) time / (double) fees[2]) * fees[3];
            }
            result[index][0] = key;
            result[index++][1] = fee;
        }

        Arrays.sort(result, (e1, e2) -> e1[0] - e2[0]);

        answer = new int[result.length];

        for (int i = 0; i < result.length; i++) {
            answer[i] = result[i][1];
        }

        return answer;
    }

    public int getTime(String str) {
        String[] tmp = str.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}