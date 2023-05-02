import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            switch(str[0]) {
                case "Enter":
                    map.put(str[1], str[2]);
                    cnt++;
                    break;
                case "Change":
                    map.put(str[1], str[2]);
                    break;
                default:
                    cnt++;
            }
        }
        
        // System.out.println(map);
        
        answer = new String[cnt];
        cnt = 0;
        for(int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            String name = map.get(str[1]);
            switch(str[0]) {
                case "Enter":
                    answer[cnt++] = name + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    answer[cnt++] = name + "님이 나갔습니다.";
                    break;
            }
        }
        
        return answer;
    }
}