import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = { -1, 0, 1, 0, 0, 0 };
    static int dy[] = { 0, 1, 0, -1, 0, 0 };
    static int dz[] = { 0, 0, 0, 0, 1, -1 };
    static boolean[][][] ch;
    static int[][][] map;
    static int M, N, H;
    static int dep = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        ch = new boolean[H][N][M];

        int flag = -1;
        for (int t = 0; t < H; t++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[t][i][j] = Integer.parseInt(st.nextToken());
                    if (map[t][i][j] == 0)
                        flag = 1;
                }
            }
        }

        if (flag == -1) {
            System.out.println(0);
            System.exit(0);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int t = 0; t < H; t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[t][i][j] == 1 && !ch[t][i][j]) {
                        q.offer(new int[] { i, j, t, 0 });
                    }
                }
            }
        }

        BFS(q);

        for (int t = 0; t < H; t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[t][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(dep);

    }

    // public static void BFS(int h, int x, int y, int depth) {
    public static void BFS(Queue<int[]> q) {
        // Queue<int[]> q = new LinkedList<>();
        // q.offer(new int[] { x, y, h, depth });
        // ch[h][x][y] = true;

        while (!q.isEmpty()) {
            int[] n = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = n[0] + dx[i];
                int ny = n[1] + dy[i];
                int nz = n[2] + dz[i];
                int nd = n[3] + 1;

                if (nx >= N || nx < 0 || ny >= M || ny < 0 || nz >= H || nz < 0 || map[nz][nx][ny] != 0)
                    continue;
                ch[nz][nx][ny] = true;
                map[nz][nx][ny] = 1;
                q.offer(new int[] { nx, ny, nz, nd });
                dep = Math.max(nd, dep);
            }
        }
    }
}