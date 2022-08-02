import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max, cnt;
	static char[][] map;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 2; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						swap(i, j, nx, ny);

						// char[] col = new char[N];
						// for (int k = 0; k < N; k++) {
						// col[k]=map[k][j];
						// }
						//
						// char[] row = new char[N];
						// for (int k = 0; k < N; k++) {
						// row[k] = map[i][k];
						// }

						max = Math.max(max, search());

						swap(nx, ny, i, j);
					}

				}
			}
		}
		System.out.println(max);

	}

	static int search() { // 모든 행에대해 연속된 열의 개수 셈

		int bigger = 0;

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (map[i][j] == map[i][j - 1]) {
					cnt++;
					bigger = Math.max(bigger, cnt);
				} else {
					cnt = 1;

				}

			}

		}

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (map[j][i] == map[j - 1][i]) {
					cnt++;
					bigger = Math.max(bigger, cnt);
				} else {
					cnt = 1;

				}

			}
			// bigger = Math.max(bigger, cnt);

		}
		return bigger;
	}

	static void swap(int i, int j, int nx, int ny) {
		char temp = map[i][j];
		map[i][j] = map[nx][ny];
		map[nx][ny] = temp;
	}

}