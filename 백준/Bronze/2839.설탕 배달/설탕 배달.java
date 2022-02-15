import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

		int            N   = Integer.parseInt(br.readLine());

		int            i   = 0;
		int            min = Integer.MAX_VALUE;

		if (N % 3 == 0) {
			min = N / 3;
		}

		while (true) {
			i++;
			if (5 * i > N) {
				break;
			}
			int n1 = N - (5 * i);
			if (n1 % 3 != 0) {
				continue;
			}

			int n2 = n1 / 3;
			min = min < n2 + i ? min : n2 + i;
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

}
