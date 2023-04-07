import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 0:
                    union(b, c);
                    break;
                case 1:
                    if (isSameSet(b, c)) {
                        bw.write("YES\n");
                    } else {
                        bw.write("NO\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            arr[y] = x;
        } else {
            arr[x] = y;
        }
    }

    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public static boolean isSameSet(int x, int y) {
        if (find(x) == find(y)) {
            return true;
        }
        return false;
    }
}
