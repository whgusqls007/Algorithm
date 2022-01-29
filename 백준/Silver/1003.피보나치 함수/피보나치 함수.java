import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr = new int[41][2];

	public static void main(String[] args) throws Exception {
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;

		BufferedReader br        = new BufferedReader(new InputStreamReader(System.in));
		int            n         = Integer.parseInt(br.readLine());
		int            lastIndex = 1;
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if (m > lastIndex) {
				for (int j = lastIndex + 1; j < m + 1; j++) {
					arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
					arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
				}
				lastIndex = m;
			}
			System.out.printf("%d %d\n", arr[m][0], arr[m][1]);
		}
	}
}