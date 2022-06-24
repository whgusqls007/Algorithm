import java.io.*;
import java.util.*;

class Info {
	int y;
	int x;
	int breaking;
	int count;

	public Info(int y, int x, int breaking, int count) {
		this.y = y;
		this.x = x;
		this.breaking = breaking;
		this.count = count;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		char[][] arr = new char[Y][X];

		for (int i = 0; i < Y; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		Queue<Info> q = new LinkedList<>();

		q.offer(new Info(0, 0, 0, 1));

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		boolean[][][] visit = new boolean[Y][X][2];
		visit[0][0][0] = true;
		visit[0][0][1] = true;
		boolean flag = false;

		while (!q.isEmpty()) {
			// for (int i = 0; i < Y; i++) {
			// for (int j = 0; j < X; j++) {
			// System.out.print(Arrays.toString(visit[i][j]));
			// System.out.print("\t");
			// }
			// System.out.println();
			// }
			// System.out.println();
			Info info = q.poll();
			int y = info.y;
			int x = info.x;
			int breaking = info.breaking;
			int count = info.count;

			if (y == Y - 1 && x == X - 1) {
				System.out.println(count);
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny > Y - 1 || nx > X - 1) {
					continue;
				}

				if (breaking == 0) {
					if (arr[ny][nx] == '0') {

						if (visit[ny][nx][0]) {
							continue;
						}

						visit[ny][nx][0] = true;
						q.offer(new Info(ny, nx, 0, count + 1));
					} else {

						if (visit[ny][nx][1]) {
							continue;
						}

						visit[ny][nx][1] = true;
						q.offer(new Info(ny, nx, 1, count + 1));
					}
				} else {
					if (arr[ny][nx] == '1') {
						continue;
					}

					if (visit[ny][nx][1]) {
						continue;
					}

					visit[ny][nx][1] = true;
					q.offer(new Info(ny, nx, 1, count + 1));
				}
			}
		}
		if (!flag) {
			System.out.println(-1);
		}
	}
}