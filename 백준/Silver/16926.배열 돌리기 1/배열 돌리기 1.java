import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw    = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st    = new StringTokenizer(br.readLine());
		int             N     = Integer.parseInt(st.nextToken());
		int             M     = Integer.parseInt(st.nextToken());
		int             R     = Integer.parseInt(st.nextToken());
		int[][]         arr   = new int[N][M];
		int             count = 0;
		int[]           dx    =
			{
					0, 1, 0, -1
			};
		int[]           dy    =
			{
					1, 0, -1, 0
			};

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < count; j++) {
				int x   = j;
				int y   = j;
				int num = arr[x][y];
				for (int idx = 0; idx < 4;) {
					int ny = y + dy[idx];
					int nx = x + dx[idx];

					if (ny >= j && nx >= j && ny < M - j && nx < N - j) {
						arr[x][y] = arr[nx][ny];
						x         = nx;
						y         = ny;
					} else {
						idx++;
					}
				}
				arr[j + 1][j] = num;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}