import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br     = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw     = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][]        check  = null;
	static int[][]        houses = null;
	static int            N      = 0;
	static int            cnt    = 1;
	static int[]          result = null;
	static int[]          dx     =
		{
				-1, 0, 1, 0
		};
	static int[]          dy     =
		{
				0, -1, 0, 1
		};

	public static void main(String[] args) throws Exception {
		N      = Integer.parseInt(br.readLine());
		houses = new int[N][N];
		check  = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				houses[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
			}
		}

		// bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (houses[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		result = new int[cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] != 0) {
					result[check[i][j]]++;
				}
			}
		}
		Arrays.sort(result);
		bw.write((cnt - 1) + "\n");
		for (int i = 1; i < cnt; i++) {
			bw.write(result[i] + "\n");
		}
		bw.flush();
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (houses[i][j] == 0) {
					continue;
				}
				q.offer(new int[]
					{
							i, j
					});
				while (!q.isEmpty()) {
					int[] tmp = q.poll();
					int   y   = tmp[0];
					int   x   = tmp[1];
					if (houses[y][x] == 0) {
						continue;
					}
					check[y][x]  = cnt;
					houses[y][x] = 0;
					for (int k = 0; k < 4; k++) {
						int tmpY = y + dy[k];
						int tmpX = x + dx[k];
						if (tmpY > -1 && tmpY < N && tmpX > -1 && tmpX < N && houses[tmpY][tmpX] == 1) {
							q.offer(new int[]
								{
										tmpY, tmpX
								});
						}
					}
				}
				cnt++;
			}
		}
	}

	static void dfs(int i, int j) {
		houses[i][j] = 0;
		check[i][j]  = cnt;
		for (int k = 0; k < 4; k++) {
			int tmpY = i + dy[k];
			int tmpX = j + dx[k];
			if (tmpY > -1 && tmpY < N && tmpX > -1 && tmpX < N && houses[tmpY][tmpX] == 1) {
				dfs(tmpY, tmpX);
			}
		}
	}

}
