import java.io.*;
import java.util.*;

public class Main {
	static int N, sum;
	static int[][] check;
	static char[][] arr;
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (arr[i][j] != '1') {
					continue;
				}

				int cnt = 1;
				while (checkPlus(i, j, cnt)) {
					cnt++;
					sum++;
					if (i - cnt < 0 || i + cnt > N - 1 || j - cnt < 0 || j + cnt > N - 1) {
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}

	public static boolean checkPlus(int y, int x, int cnt) {
		for (int i = 0; i < 4; i++) {
			int ny = y + (dy[i] * cnt);
			int nx = x + (dx[i] * cnt);

			if (arr[ny][nx] != '1') {
				return false;
			}

			if (i == 0 || i == 2) {
				for (int j = 1; j <= cnt; j++) {
					if (arr[ny][nx - j] == '1' || arr[ny][nx + j] == '1') {
						return false;
					}
				}
			} else {
				for (int j = 1; j <= cnt; j++) {
					if (arr[ny - j][nx] == '1' || arr[ny + j][nx] == '1') {
						return false;
					}
				}
			}
		}
		return true;
	}
}
