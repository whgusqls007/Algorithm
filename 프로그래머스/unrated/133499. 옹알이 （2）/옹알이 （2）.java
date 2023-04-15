import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            if(check(babbling[i])) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean check(String word) {
        String[] words = {"aya", "ye", "woo", "ma"};
        while(word.length() > 1) {
            if(word.length() > 2) {
                if(word.substring(0, 2).equals("ye")) {
                    word = word.replaceFirst("ye", "");
                    if(word.length() == 0) {
                        return true;
                    }
                    else if(word.length() > 1 && word.substring(0, 2).equals("ye")) {
                        return false;
                    }
                }
                else if(word.substring(0, 2).equals("ma")) {
                    word = word.replaceFirst("ma", "");
                    if(word.length() == 0) {
                        return true;
                    }
                    else if(word.length() > 1 &&word.substring(0, 2).equals("ma")) {
                        return false;
                    }
                }
                else if(word.substring(0, 3).equals("aya")) {
                    word = word.replaceFirst("aya", "");
                    if(word.length() == 0) {
                        return true;
                    } else if(word.length() > 2 && word.substring(0, 3).equals("aya")) {
                        return false;
                    }
                }
                else if(word.substring(0, 3).equals("woo")) {
                    word = word.replaceFirst("woo", "");
                    if(word.length() == 0) {
                        return true;
                    }
                    else if(word.length() > 2 && word.substring(0, 3).equals("woo")) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if(word.length() == 2) {
                if(word.substring(0, 2).equals("ye")) {
                    word = word.replaceFirst("ye", "");
                    if(word.length() == 0) {
                        return true;
                    }
                    else if(word.length() > 1 && word.substring(0, 2).equals("ye")) {
                        return false;
                    }
                }
                else if(word.substring(0, 2).equals("ma")) {
                    word = word.replaceFirst("ma", "");
                    if(word.length() == 0) {
                        return true;
                    }
                    else if(word.length() > 1 && word.substring(0, 2).equals("ma")) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if(word.length() == 1) {
            return false;
        }
        return true;
    }
}