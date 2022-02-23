package boj10026_적록색약;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int      N;
	static char[][] arr;
	static int[][]  iarr;
	static int[]    dy   =
		{
				-1, 0, 1, 0
		};
	static int[]    dx   =
		{
				0, 1, 0, -1
		};
	static int      cnt1 = 1;
	static int      cnt2 = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N    = Integer.parseInt(br.readLine());
		arr  = new char[N][N];
		iarr = new int[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (iarr[i][j] == 0) {
					dfs(i, j, cnt1);
					cnt1++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'R') arr[i][j] = 'G';
			}
		}
		iarr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (iarr[i][j] == 0) {
					dfs(i, j, cnt2);
					cnt2++;
				}
			}
		}
		bw.write(String.format("%d %d", cnt1 - 1, cnt2 - 1));
		bw.flush();
	}

	static void dfs(int y, int x, int cnt) {
		iarr[y][x] = cnt;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > N - 1) continue;
			if (iarr[ny][nx] != 0 || arr[ny][nx] != arr[y][x]) continue;
			dfs(ny, nx, cnt);
		}
	}
}
