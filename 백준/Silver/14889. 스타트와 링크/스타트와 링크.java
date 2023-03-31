import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int min;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(min);
    }

    public static void dfs(int bitMask, int link, int start, int depth) {
        if (link + start == N) {
            if (link == N / 2 && start == N / 2) {
                int sub = check(bitMask);
                if (sub == 0) {
                    System.out.println(0);
                    System.exit(0);
                } else {
                    min = Math.min(min, sub);
                }
            } else {
                return;
            }
        } else if (link + start > N) {
            return;
        }

        dfs(bitMask | (1 << depth), link + 1, start, depth + 1);
        dfs(bitMask, link, start + 1, depth + 1);
    }

    public static int check(int bitMask) {
        int link = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((bitMask & (1 << i)) == (1 << i) && (bitMask & (1 << j)) == (1 << j)) {
                    link += arr[i][j];
                    link += arr[j][i];
                } else if ((bitMask & (1 << i)) == 0 && (bitMask & (1 << j)) == 0) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
            }
        }

        return Math.abs(link - start);
    }
}
