import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             N   = Integer.parseInt(st.nextToken());
		int             D   = Integer.parseInt(st.nextToken());
		int[][]         arr = new int[N][3];
		int[]           dp  = new int[D + 2];

		for (int i = 0; i < N; i++) {
			st        = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < D + 2; i++)
			dp[i] = i;

		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		for (int i = 0; i < N; i++) {
			int from = arr[i][0];
			int to   = arr[i][1];
			int dist = arr[i][2];
			if (to > D) {
				continue;
			}
			if (dp[to] > dp[from] + dist) {
				dp[to] = dp[from] + dist;
				for (int j = to + 1; j < D + 2; j++) {
					dp[j] = Math.min(dp[j - 1] + 1, dp[j]);
				}
			}
		}
		System.out.println(dp[D]);
	}
}