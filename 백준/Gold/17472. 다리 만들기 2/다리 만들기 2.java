import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] map;
    static ArrayList<int[]> al;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numbering();

        al = new ArrayList<>();
        makeBridge();
        Collections.sort(al, (e1, e2) -> e1[2] - e2[2]);

        int total = 0;
        for (int i = 0; i < al.size(); i++) {
            int[] bridge = al.get(i);
            int isle1 = bridge[0];
            int isle2 = bridge[1];
            int cost = bridge[2];

            if (find(isle1) != find(isle2)) {
                union(isle1, isle2);
                total += cost;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (find(i - 1) != find(i)) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(total);
    }

    public static void numbering() {
        int cnt = 1;
        boolean[][] visit = new boolean[N][M];
        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, 1, 0, -1 };
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    ArrayDeque<int[]> dq = new ArrayDeque<>();
                    dq.offerLast(new int[] { i, j });
                    visit[i][j] = true;
                    map[i][j] = cnt;
                    while (!dq.isEmpty()) {
                        int[] cur = dq.pollFirst();
                        int cy = cur[0];
                        int cx = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int ny = cy + dy[k];
                            int nx = cx + dx[k];

                            if (ny > N - 1 || ny < 0 || nx > M - 1 || nx < 0) {
                                continue;
                            }

                            if (visit[ny][nx]) {
                                continue;
                            }

                            if (map[ny][nx] == 0) {
                                continue;
                            }

                            dq.offerLast(new int[] { ny, nx });
                            map[ny][nx] = cnt;
                            visit[ny][nx] = true;
                        }
                    }
                    cnt++;
                }
            }
        }
        arr = new int[cnt];
        for (int i = 1; i < cnt; i++) {
            arr[i] = i;
        }
    }

    public static void makeBridge() {
        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, 1, 0, 1 };
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                ArrayDeque<int[]> dq = new ArrayDeque<>();
                dq.offerLast(new int[] { i, j, 0, 0 });
                dq.offerLast(new int[] { i, j, 1, 0 });
                dq.offerLast(new int[] { i, j, 2, 0 });
                dq.offerLast(new int[] { i, j, 3, 0 });

                while (!dq.isEmpty()) {
                    int[] cur = dq.pollFirst();
                    int cy = cur[0];
                    int cx = cur[1];
                    int dir = cur[2];
                    int cnt = cur[3];

                    int ny = cy + dy[dir];
                    int nx = cx + dx[dir];

                    if (ny > N - 1 || ny < 0 || nx > M - 1 || nx < 0) {
                        continue;
                    }

                    if (map[ny][nx] == map[i][j]) {
                        continue;
                    } else if (map[ny][nx] == 0) {
                        dq.offerLast(new int[] { ny, nx, dir, cnt + 1 });
                    } else {
                        if (cnt < 2) {
                            continue;
                        }
                        al.add(new int[] { map[i][j], map[ny][nx], cnt });
                    }
                }
            }
        }
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
