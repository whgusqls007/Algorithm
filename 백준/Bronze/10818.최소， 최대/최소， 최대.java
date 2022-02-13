import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             min = Integer.MAX_VALUE;
		int             max = Integer.MIN_VALUE;
		int             num = 0;

		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}

		System.out.println(min + " " + max);
	}
}