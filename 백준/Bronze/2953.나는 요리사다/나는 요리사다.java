import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st    = null;
		int             max   = Integer.MIN_VALUE;
		int             sum   = 0;
		int             index = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if (max < sum) {
				max   = sum;
				index = i + 1;
			}
			sum = 0;
		}

		System.out.println(index + " " + max);
	}
}