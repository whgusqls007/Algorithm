import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Main {
    static int N, M, count;
    static int[] arr;
    static int[][] map;
    static ArrayList<int[]>[] al;

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

        al = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            al[i] = new ArrayList<>();
        }

        makeBridge();

        System.out.println(prim());

    }

    public static int prim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.offer(new int[] { 1, 0 });
        int cnt = 1;
        int total = 0;
        boolean[] visit = new boolean[count];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visit[cur[0]]) {
                continue;
            }
            visit[cur[0]] = true;
            total += cur[1];
            cnt++;
            if (count == cnt) {
                return total;
            }

            for (int i = 0; i < al[cur[0]].size(); i++) {
                int[] next = al[cur[0]].get(i);
                if (visit[next[0]]) {
                    continue;
                }
                pq.offer(next);
            }
        }
        return -1;
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
        count = cnt;
    }

    public static void makeBridge() {
        int[] dy = { 0, 1 };
        int[] dx = { 1, 0 };
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                ArrayDeque<int[]> dq = new ArrayDeque<>();
                dq.offerLast(new int[] { i, j, 0, 0 });
                dq.offerLast(new int[] { i, j, 1, 0 });

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
                        al[map[i][j]].add(new int[] { map[ny][nx], cnt });
                        al[map[ny][nx]].add(new int[] { map[i][j], cnt });
                    }
                }
            }
        }
    }
}
