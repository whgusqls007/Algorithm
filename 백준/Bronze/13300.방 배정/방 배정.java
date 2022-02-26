import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw     = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st     = new StringTokenizer(br.readLine());

		int             N      = Integer.parseInt(st.nextToken());
		int             K      = Integer.parseInt(st.nextToken());
		int             rooms  = 0;

		int[]           mail   = new int[7];
		int[]           femail = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			if (s == 0) {
				femail[g]++;
			} else {
				mail[g]++;
			}
		}

		for (int i = 1; i < 7; i++) {
			rooms += mail[i] / K;
			rooms += mail[i] % K == 0 ? 0 : 1;
			rooms += femail[i] / K;
			rooms += femail[i] % K == 0 ? 0 : 1;
		}

		System.out.println(rooms);
	}
}