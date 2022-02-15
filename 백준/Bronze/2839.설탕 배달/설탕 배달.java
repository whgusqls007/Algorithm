import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());
		int[]          arr = new int[N + 1];
		if (N == 1 || N == 2 || N == 4) {
			System.out.println(-1);
			return;
		}
		if (N == 5 || N == 3) {
			System.out.println(1);
			return;
		}

		Arrays.fill(arr, 10000);
		if (N > 5) {
			arr[3] = arr[5] = 1;
		}
		for (int i = 6; i < N + 1; i++) {
			arr[i] = Math.min(arr[i - 3] + 1, arr[i - 5] + 1);
		}

		System.out.println(arr[N] >= 10000 ? -1 : arr[N]);
	}

}