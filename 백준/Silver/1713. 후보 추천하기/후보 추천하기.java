import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> list = new LinkedList<>();

        continuePoint: for (int m = 0; m < M; m++) {
            int candi = Integer.parseInt(st.nextToken());
            for (int i = 0; i < list.size(); i++) {
                int[] node = list.get(i);
                if (node[0] == candi) {
                    node[1]++;
                    Collections.sort(list, (e1, e2) -> e1[1] - e2[1] == 0 ? -(e1[2] - e2[2]) : -(e1[1] - e2[1]));
                    continue continuePoint;
                }
            }

            if (list.size() >= N) {
                if (list.get(list.size() - 1)[1] > 1) {
                    list.remove(list.size() - 1);
                    list.add(new int[] { candi, 1, m });
                } else {
                    int i = list.size() - 1;
                    for (; i > -1; i--) {
                        if (list.get(i)[1] != 1) {
                            break;
                        }
                    }
                    list.add(i + 1, new int[] { candi, 1, m });
                    list.remove(list.size() - 1);
                }
            } else {
                int i = list.size() - 1;
                for (; i > -1; i--) {
                    if (list.get(i)[1] != 1) {
                        break;
                    }
                }
                list.add(i + 1, new int[] { candi, 1, m });
            }
        }

        Collections.sort(list, (e1, e2) -> e1[0] - e2[0]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)[0] + " ");
        }

        System.out.println(sb.toString());
    }
}