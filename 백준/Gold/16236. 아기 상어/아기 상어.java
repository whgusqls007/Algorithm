import java.io.*;
import java.util.*;

public class Main {
	static int N, sy, sx, count, size, time;
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 7) {
				} else if (map[i][j] == 9) {
					sy = i;
					sx = j;
				}
			}
		}

		while (true) {
			int[] result = bfs();
			if (result == null) {
				break;
			}
			map[sy][sx] = 0;
			time += result[2];
			sy = result[0];
			sx = result[1];
			map[sy][sx] = 9;
			count++;
			if (count == size) {
				size += 1;
				count = 0;
			}
		}
		System.out.println(time);
	}

	public static int[] bfs() {
		Queue<int[]> q = new LinkedList<>(); // { y, x, d }
		q.offer(new int[] { sy, sx, 0 });

		boolean[][] visit = new boolean[N][N];
		visit[sy][sx] = true;

		List<int[]> list = new ArrayList<>();

		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int d = q.poll()[2];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				// 범위 체크
				if (ny < 0 || nx < 0 || ny > N - 1 || nx > N - 1) {
					continue;
				}

				// 방문한곳일때
				if (visit[ny][nx]) {
					continue;
				}

				// 크기가 큰 물고기일때
				if (map[ny][nx] > size) {
					continue;
				}

				// 크기가 작은 물고기일때
				if (map[ny][nx] < size && map[ny][nx] > 0) {
					visit[ny][nx] = true;
					list.add(new int[] { ny, nx, d + 1 });
					continue;
				}

				// 크기가 같은 물고기거나 빈칸일때
				if (map[ny][nx] == size || map[ny][nx] == 0) {
					visit[ny][nx] = true;
					q.offer(new int[] { ny, nx, d + 1 });
					continue;
				}
			}
		}

		Collections.sort(list, (e1, e2) -> e1[2] != e2[2] ? Integer.compare(e1[2], e2[2])
				: e1[0] != e2[0] ? Integer.compare(e1[0], e2[0]) : Integer.compare(e1[1], e2[1]));

		return list.size() == 0 ? null : list.get(0);
	}
}
