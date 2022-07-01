import java.io.*;
import java.util.*;

public class Main {
	static int N, M, Ry, Rx, By, Bx;
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					Ry = i;
					Rx = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					By = i;
					Bx = j;
					map[i][j] = '.';
				}
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { Ry, Rx, By, Bx, 0, -1 });

		breakPoint: while (!q.isEmpty()) {
			int ry = q.peek()[0];
			int rx = q.peek()[1];
			int by = q.peek()[2];
			int bx = q.peek()[3];
			int count = q.peek()[4];
			int prevDir = q.poll()[5];

			for (int i = 0; i < 4; i++) {
				if (i == prevDir) {
					continue;
				}
				int[] returnValue = null;
				switch (i) {
				case 0:
					returnValue = move(ry < by, i, ry, rx, by, bx, count);
					break;
				case 1:
					returnValue = move(rx > bx, i, ry, rx, by, bx, count);
					break;
				case 2:
					returnValue = move(ry > by, i, ry, rx, by, bx, count);
					break;
				case 3:
					returnValue = move(rx < bx, i, ry, rx, by, bx, count);
					break;
				}

				if (returnValue == null) {
					continue;
				}

				if (returnValue[0] == -1) {
					return count + 1;
				}

//				for (int j = 0; j < N; j++) {
//					for (int k = 0; k < M; k++) {
//						if (j == returnValue[0] && k == returnValue[1]) {
//							System.out.print("R ");
//							continue;
//						}
//						if (j == returnValue[2] && k == returnValue[3]) {
//							System.out.print("B ");
//							continue;
//						}
//						System.out.print(map[j][k] + " ");
//					}
//					System.out.println();
//				}

				if (returnValue[4] >= 10) {
					continue;
				}

				q.offer(returnValue);
			}
		}
		return -1;
	}

	public static int[] redFirst(int d, int y1, int x1, int y2, int x2, int c) {
		int ry = y1;
		int rx = x1;
		int by = y2;
		int bx = x2;
		int[] result = null;

		while (true) {
			int ny = ry + dy[d];
			int nx = rx + dx[d];
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
				break;
			}
			if (map[ny][nx] == '#') {
				break;
			}
			if (map[ny][nx] == 'O') {
				result = new int[] { -1 };
				ry = ny;
				rx = nx;
				break;
			}
			ry = ny;
			rx = nx;
		}

		while (true) {
			int ny = by + dy[d];
			int nx = bx + dx[d];
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
				break;
			}
			if (map[ny][nx] == '#') {
				break;
			}
			if (map[ny][nx] == 'O') {
				result = new int[] { -2 };
				break;
			}
			if (ny == ry && nx == rx) {
				break;
			}
			by = ny;
			bx = nx;
		}
		if (result == null) {
			return new int[] { ry, rx, by, bx, c + 1, d };
		} else if (result[0] == -2) {
			return null;
		}
		return new int[] { -1 };
	}

	public static int[] blueFirst(int d, int y1, int x1, int y2, int x2, int c) {
		int ry = y1;
		int rx = x1;
		int by = y2;
		int bx = x2;
		int[] result = null;

		while (true) {
			int ny = by + dy[d];
			int nx = bx + dx[d];
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
				break;
			}
			if (map[ny][nx] == '#') {
				break;
			}
			if (map[ny][nx] == 'O') {
				return null;
			}
			by = ny;
			bx = nx;
		}

		while (true) {
			int ny = ry + dy[d];
			int nx = rx + dx[d];
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
				break;
			}
			if (map[ny][nx] == '#') {
				break;
			}
			if (map[ny][nx] == 'O') {
				result = new int[] { -1 };
				break;
			}
			if (ny == by && nx == bx) {
				break;
			}
			ry = ny;
			rx = nx;
		}

		if (result == null) {
			return new int[] { ry, rx, by, bx, c + 1, d };
		}
		return result;

	}

	public static int[] move(boolean flag, int d, int y1, int x1, int y2, int x2, int c) {
		if (flag) {
			return redFirst(d, y1, x1, y2, x2, c);
		}
		return blueFirst(d, y1, x1, y2, x2, c);
	}
}
