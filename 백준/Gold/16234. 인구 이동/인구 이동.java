import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            visit = new boolean[N][N];
            boolean isFinished = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        if (bfs(i, j, N, L, R)) {
                            isFinished = true;
                        }
                    }
                }
            }

            if (!isFinished) {
                break;
            }

            day++;
        }

        System.out.println(day);
    }

    public static boolean bfs(int y, int x, int N, int L, int R) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        ArrayList<int[]> al = new ArrayList<>();
        dq.offerLast(new int[] { y, x });
        al.add(new int[] { y, x });
        visit[y][x] = true;

        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, 1, 0, -1 };
        int cnt = 1;
        int sum = arr[y][x];

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1) {
                    continue;
                }

                if (visit[ny][nx]) {
                    continue;
                }
                int sub = Math.abs(arr[cy][cx] - arr[ny][nx]);

                if (sub < L || R < sub) {
                    continue;
                }

                dq.offerLast(new int[] { ny, nx });
                al.add(new int[] { ny, nx });
                visit[ny][nx] = true;
                cnt++;
                sum += arr[ny][nx];
            }
        }

        if (cnt == 1) {
            return false;
        }

        int pop = sum / cnt;
        for (int i = 0; i < al.size(); i++) {
            int[] tmp = al.get(i);
            arr[tmp[0]][tmp[1]] = pop;
        }

        return true;
    }
}