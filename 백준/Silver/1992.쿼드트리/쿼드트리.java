import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());
		char[][]       arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		StringBuilder sb = check(new StringBuilder(), N, arr, 0, 0);
		System.out.println(sb);
	}

	static StringBuilder check(StringBuilder sb, int N, char[][] arr, int x, int y) {
		char    prev = arr[y][x];
		boolean flag = true;
		breakPoint: for (int i = y; i < y + N; i++) {
			for (int j = x; j < x + N; j++) {
				if (prev != arr[i][j]) {
					flag = false;
					break breakPoint;
				}
				prev = arr[i][j];
			}
		}

		if (flag) {
			sb.append(String.valueOf(arr[y][x]));
			return sb;
		} else {
			sb.append("(");

			// 1 사분면
			sb = check(sb, N / 2, arr, x, y);
			// 2 사분면
			sb = check(sb, N / 2, arr, x + N / 2, y);
			// 3 사분면
			sb = check(sb, N / 2, arr, x, y + N / 2);
			// 4 사분면
			sb = check(sb, N / 2, arr, x + N / 2, y + N / 2);

			sb.append(")");
			return sb;
		}
	}
}