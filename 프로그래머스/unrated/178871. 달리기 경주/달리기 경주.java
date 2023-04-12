import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            String name = callings[i];
            int rank = map.get(name);
            
            map.put(name, rank - 1);
            map.put(players[rank - 1], rank);
            
            String tmp = players[rank];
            players[rank] = players[rank - 1];
            players[rank - 1] = tmp;
        }
        
        return players;
    }
}