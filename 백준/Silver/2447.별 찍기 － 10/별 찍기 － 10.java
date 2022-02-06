import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br      = null;
	static BufferedWriter bw      = null;
	static int            N       = 0;
	static char[][]       charArr = null;

	public static void main(String[] args) throws Exception {
		br      = new BufferedReader(new InputStreamReader(System.in));
		bw      = new BufferedWriter(new OutputStreamWriter(System.out));
		N       = Integer.parseInt(br.readLine());
		charArr = new char[N][N];

		recursion(0, 0, N, false);

		for (char[] arr : charArr) {
			bw.write(arr);
			bw.write("\n");
		}

		bw.flush();
	}

	static void recursion(int x, int y, int N, boolean blank) throws Exception {
		if (blank) {
			for (int i = y; i < y + N; i++) {
				for (int j = x; j < x + N; j++) {
					charArr[i][j] = ' ';
				}
			}
			return;
		}
		if (N == 1) {
			charArr[y][x] = '*';
			return;
		}
		
		int cnt = 0;
		
		for (int i = y; i < y + N; i += N / 3) {
			for (int j = x; j < x + N; j += N / 3) {
				if (++cnt == 5) {
					recursion(i, j, N / 3, true);
				} else {
					recursion(i, j, N / 3, false);
				}
			}
		}
	}
}