import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new LinkedList<>(); // new int[] {y, x, time}

		int one = 0;
		int two = 0;
		int three = 0;
		int N = Integer.parseInt(st.nextToken()); // Y축
		int M = Integer.parseInt(st.nextToken()); // X축
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					one++;
					q.offer(new int[] { i, j, 0 });
				} else if (map[i][j] == 2) {
					two++;
					q.offer(new int[] { i, j, 0 });
				} else if (map[i][j] == 3) {
					three++;
				}
			}
		}

		int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
		int[][] times = new int[N][M];

		while (!q.isEmpty()) {
			int y = q.peek()[0]; // 현재 도시 y 좌표
			int x = q.peek()[1]; // 현재 도시 x 좌표
			int t = q.poll()[2]; // 현재 도시의 시간
			int v = map[y][x]; // 현재 도시의 값

			if (v == 3) { // 3번 바이러스라면 확산이 안됨
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				// 범위 체크
				if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
					continue;
				}

				if (map[ny][nx] == -1) {
					continue;
				}

				// 치료제가 없을 때
				if (map[ny][nx] == 0) {
					q.offer(new int[] { ny, nx, t + 1 });
					times[ny][nx] = t + 1;
					map[ny][nx] = v;

					if (v == 1) {
						one++;
					} else if (v == 2) {
						two++;
					}

					continue;
				}

				// 현재 바이러스가 2번이고 1번 바이러스에 감염된 도시일 때 감염 시간이 같다면
				if (v == 2 && map[ny][nx] == 1 && times[ny][nx] == t + 1) {
					map[ny][nx] = 3;
					three++;
					one--;
					continue;
				}

				// 현재 바이러스가 1번이고 2번 바이러스에 감연됨 도시일 때 감염 시간이 같다면
				if (v == 1 && map[ny][nx] == 2 && times[ny][nx] == t + 1) {
					map[ny][nx] = 3;
					three++;
					two--;
					continue;
				}
			}
		}

		System.out.printf("%d %d %d", one, two, three);
	}
}
