class Solution {
    public int[] solution(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i + 1;
        }
        int T = n / 3 + (n % 3 != 0 ? 1 : 0);

        int[] answer = new int[sum];

        int cnt = n;
        int index = 0;
        int num = 1;
        int c = 0;
        breakPoint: for (int t = 0; t < T; t++) {
            for (int i = 0; i < cnt; i++) {
                answer[index] = num++;
                if (num > sum) {
                    break breakPoint;
                }
                index += ++c;
            }

            index -= --c;
            for (int i = index; i < index + cnt - 1; i++) {
                answer[i] = num++;
            }

            index -= 2 * (t + 1);

            for (int i = 0; i < cnt - 2; i++) {
                answer[index] = num++;
                index -= c--;
            }
            c++;
            index += 4 * (t + 1);
            cnt -= 3;
        }

        return answer;
    }
}