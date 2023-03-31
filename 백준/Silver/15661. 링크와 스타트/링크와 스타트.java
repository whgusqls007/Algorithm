import java.util.*;
import java.io.*;

public class Main {
    static int N = 0;
    static int min = Integer.MAX_VALUE;
    static int[][] arr = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int depth, int bitMask) {
        if (depth == N) {

            if (bitMask == 0 || bitMask == Math.pow(2, N) - 1) {
                return;
            }

            int sub = check(bitMask);
            if (sub == 0) {
                System.out.println(0);
                System.exit(0);
            } else {
                min = Math.min(min, sub);
            }

            return;
        }
        dfs(depth + 1, bitMask | (1 << depth));
        dfs(depth + 1, bitMask);
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