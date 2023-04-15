class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minX = 51;
        int minY = 51;
        int maxX = -1;
        int maxY = -1;
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                }
            }
        }
        answer = new int[] {minX, minY, maxX, maxY};
        return answer;
    }
}