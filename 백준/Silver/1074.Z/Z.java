import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw     = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st     = new StringTokenizer(br.readLine());
		int             N      = Integer.parseInt(st.nextToken());
		int             NSqure = (int) Math.pow(2, N);

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		while (NSqure != 0) {

			int size = NSqure / 2;
			if (r < size && c < size) {
				// do nothing
			} else if (r < size && c >= size) {
				cnt += NSqure * NSqure / 4;
				c   -= size;
			} else if (r >= size && c < size) {
				cnt += NSqure * NSqure / 4 * 2;
				r   -= size;
			} else {
				cnt += NSqure * NSqure / 4 * 3;
				r   -= size;
				c   -= size;
			}
			NSqure /= 2;
		}
		System.out.println(cnt);
	}
}
