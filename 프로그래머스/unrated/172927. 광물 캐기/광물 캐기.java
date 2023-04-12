import java.util.*;

class Solution {
    int[] dia = null;
    int[] iron = null;
    int[] stone = null;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        dia = new int[minerals.length + 1];
        iron = new int[minerals.length + 1];
        stone = new int[minerals.length + 1];
        
        for(int i = 0; i < minerals.length; i++) {
            if(minerals[i].equals("diamond")) {
                dia[i + 1] = dia[i] + 1;
                iron[i + 1] = iron[i] + 5;
                stone[i + 1] = stone[i] + 25;
            } else if(minerals[i].equals("iron")) {
                dia[i + 1] = dia[i] + 1;
                iron[i + 1] = iron[i] + 1;
                stone[i + 1] = stone[i] + 5;
            } else {
                dia[i + 1] = dia[i] + 1;
                iron[i + 1] = iron[i] + 1;
                stone[i + 1] = stone[i] + 1;
            }
        }
        // System.out.println(Arrays.toString(dia));
        // System.out.println(Arrays.toString(iron));
        // System.out.println(Arrays.toString(stone));
        
        answer = dfs(picks, minerals, 0, 0);
        return answer;
    }
    
    public int dfs(int[] picks, String[] minerals, int index, int sum) {
        int min = Integer.MAX_VALUE;
        
        if(picks[0] > 0) {
            picks[0]--;
            if(index + 5 < minerals.length + 1) {
                min = Math.min(min, dfs(picks, minerals, index + 5, sum + (dia[index + 5] - dia[index])));
            } else {
                min = Math.min(min, sum + (dia[minerals.length] - dia[index]));
            }
            picks[0]++;
        }
        if(picks[1] > 0) {
            picks[1]--;
            if(index + 5 < minerals.length + 1) {
                min = Math.min(min, dfs(picks, minerals, index + 5, sum + (iron[index + 5] - iron[index])));
            } else {
                min = Math.min(min, sum + (iron[minerals.length] - iron[index]));
            }
            picks[1]++;
        }
        if(picks[2] > 0) {
            picks[2]--;
            if(index + 5 < minerals.length + 1) {
                min = Math.min(min, dfs(picks, minerals, index + 5, sum + (stone[index + 5] - stone[index])));
            } else {
                min = Math.min(min, sum + (stone[minerals.length] - stone[index]));
            }
            picks[2]++;
        }
        return min == Integer.MAX_VALUE ? sum : min;
    }
}