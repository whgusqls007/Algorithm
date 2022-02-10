import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader  br           = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter  bw           = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st           = null;
	static int[][]         drawingPaper = new int[100][100];

	public static void main(String[] args) throws Exception {
		int N   = Integer.parseInt(br.readLine());
		int x   = 0;
		int y   = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x  = Integer.parseInt(st.nextToken());
			y  = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (drawingPaper[j][k] != 1) {
						cnt++;
						drawingPaper[j][k] = 1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}