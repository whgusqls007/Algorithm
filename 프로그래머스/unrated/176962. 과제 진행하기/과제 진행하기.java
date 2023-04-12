import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((e1, e2) -> -(e1[3] - e2[3]));
        
        
        for(int i = 0; i < plans.length; i++) {
            pq1.offer(new int[] {i, hourToMin(plans[i][1]), Integer.parseInt(plans[i][2]), 0});
        }
        
        // while(!pq1.isEmpty()) {
        //     System.out.println(Arrays.toString(pq1.poll()));
        // }
        
        int index = 0;
        int priority = 1;
        while(!pq1.isEmpty()) {
            int[] task = pq1.poll();
            if(pq1.isEmpty()) {
                answer[index++] = plans[task[0]][0];
                while(!pq2.isEmpty()) {
                    task = pq2.poll();
                    answer[index++] = plans[task[0]][0];
                }
                break;
            }
            int[] task2 = pq1.peek();
            if(task[1] + task[2] < task2[1]) {
                answer[index++] = plans[task[0]][0];
                if(pq2.isEmpty()) {
                    continue;
                } else {
                    int remainTime = task2[1] - (task[1] + task[2]);
                    while(!pq2.isEmpty()) {
                        int[] task3 = pq2.poll();
                        if(task3[2] < remainTime) {
                            remainTime = remainTime - task3[2];
                            answer[index++] = plans[task3[0]][0];
                        } else if(task3[2] > remainTime) {
                            pq2.offer(new int[] {task3[0], task3[1], task3[2] - remainTime, priority++});
                            break;
                        } else {
                            answer[index++] = plans[task3[0]][0];
                            break;
                        }
                    }
                }
            } else if(task[1] + task[2] == task2[1]) {
                answer[index++] = plans[task[0]][0];
            } else {
                pq2.offer(new int[] {task[0], task[1], task[2] - (task2[1] - task[1]), priority++});
            }
        }
        
        return answer;
    }
    
    public int hourToMin(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]) * 60;
        int min = Integer.parseInt(t[1]);
        return hour + min;
    }
}