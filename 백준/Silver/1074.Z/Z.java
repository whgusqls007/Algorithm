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
		dc(NSqure, r, c);
		System.out.println(cnt);
	}

	static void dc(int N, int y, int x) {
		if (N == 1) {
			return;
		}
		int size = N / 2;
		if (y < size && x < size) {
			dc(N / 2, y, x);
		} else if (y < size && x >= size) {
			cnt += (N * N) / 4;
			dc(size, y, x - size);
		} else if (y >= size && x < size) {
			cnt += (N * N) / 4 * 2;
			dc(size, y - size, x);
		} else {
			cnt += (N * N) / 4 * 3;
			dc(size, y - size, x - size);
		}
	}
}