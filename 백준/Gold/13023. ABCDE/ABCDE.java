import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit = null;
    static ArrayList<Integer>[] arr = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            if (dfs(0, N, i)) {
                System.out.println(1);
                System.exit(0);
            }
        }
        System.out.println(0);
    }

    public static boolean dfs(int depth, int N, int first) {
        if (depth == 4) {
            return true;
        }

        boolean rv = false;
        for (int i = 0; i < arr[first].size(); i++) {
            int second = arr[first].get(i);
            
            if (visit[second]) {
                continue;
            }

            visit[second] = true;

            rv = dfs(depth + 1, N, second);

            if (rv) {
                return rv;
            }

            visit[second] = false;
        }

        return false;
    }
}
