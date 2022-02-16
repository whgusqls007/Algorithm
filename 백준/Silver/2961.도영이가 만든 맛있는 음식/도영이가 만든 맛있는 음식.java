import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] comb = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int            N  = Integer.parseInt(br.readLine());

		if (N == 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.out
					.println(Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken())));
			return;
		}
		int[][] arr = new int[N][2];
		comb = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int  to  = N - 2;
		long min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int flavor = Math.abs(arr[i][0] - arr[i][1]);
			if (flavor < min) {
				min = flavor;
			}
		}

		for (int i = N - 1; i >= to; i--) {
			comb[i] = 1;
		}
		while (true) {
			int S = 1;
			int B = 0;
			for (int i = 0; i < N; i++) {
				if (comb[i] == 1) {
					S *= arr[i][0];
					B += arr[i][1];
				}
			}
			int flavor = Math.abs(S - B);
			if (flavor < min) {
				min = flavor;
			}
			while (np(N)) {
				S = 1;
				B = 0;
				for (int i = 0; i < N; i++) {
					if (comb[i] == 1) {
						S *= arr[i][0];
						B += arr[i][1];
					}
				}
				flavor = Math.abs(S - B);
				if (flavor < min) {
					min = flavor;
				}
			}
			to--;
			if (to == -1) {
				break;
			}
			Arrays.fill(comb, 0);
			for (int i = N - 1; i >= to; i--) {
				comb[i] = 1;
			}
		}
		System.out.println(min);
	}

	public static boolean np(int N) {
		int i = N - 1;
		while (i > 0 && comb[i - 1] >= comb[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = N - 1;
		while (comb[i - 1] >= comb[j]) {
			j--;
		}
		swap(i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	public static void swap(int i, int j) {
		int tmp = comb[i];
		comb[i] = comb[j];
		comb[j] = tmp;
	}
}