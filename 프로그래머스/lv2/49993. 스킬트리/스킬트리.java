import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put(skill.charAt(0), '0');
        for(int i = 1; i < skill.length(); i++) {
            map.put(skill.charAt(i), skill.charAt(i - 1));
        }
        
        continuePoint : for(int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            str = str.replaceAll("[^" + skill + "]", "");
            System.out.println(str);
            if(str.length() == 0) {
                answer++;
                continue;
            }
            
            Set<Character> set = new HashSet<>();
            
            if(map.get(str.charAt(0)) == '0') {
                set.add(str.charAt(0));
            } else {
                continue;
            }
            
            for(int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if(!set.contains(map.get(c))) {
                    continue continuePoint;
                }
                set.add(c);
            }
            
            answer++;
        }
        return answer;
    }
}