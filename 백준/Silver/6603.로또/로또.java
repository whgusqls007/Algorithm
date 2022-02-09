import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw    = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[]      visit = null;

	public static void main(String[] args) throws Exception {
		BufferedReader  br      = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st      = null;

		int             N       = 0;
		int[]           numbers = null;
		int[]           arr     = null;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N  = Integer.parseInt(st.nextToken());

			if (N == 0) {
				bw.flush();
				break;
			}

			numbers = new int[N];
			arr     = new int[6];
			visit   = new boolean[N];

			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			lotto(0, N, 0, numbers, arr);
			bw.write("\n");
		}
	}

	static void lotto(int depth, int N, int start, int[] numbers, int[] arr) throws Exception {
		if (depth == 6) {
			for (int i = 0; i < arr.length; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			arr[depth] = numbers[i];
			lotto(depth + 1, N, i + 1, numbers, arr);
		}
	}
}
