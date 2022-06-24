import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M, N;

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		int totalCount = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new int[] { i, j, 0 });
					cnt++;
				} else if (arr[i][j] == -1) {
					totalCount--;
				}
			}
		}

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		int lastDay = 0;

		while (!q.isEmpty()) {
			int[] tomato = q.poll();
			int y = tomato[0];
			int x = tomato[1];
			int day = tomato[2];
			lastDay = day;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
					continue;
				}

				if (arr[ny][nx] == 1) {
					continue;
				}

				if (arr[ny][nx] == -1) {
					continue;
				}

				arr[ny][nx] = 1;

				q.offer(new int[] { ny, nx, day + 1 });
				cnt++;
			}
			// for (int i = 0; i < N; i++) {
			// System.out.println(Arrays.toString(arr[i]));
			// }
			// System.out.println();
		}
		if (cnt == totalCount) {
			System.out.println(lastDay);
		} else {
			System.out.println(-1);
		}
	}
}