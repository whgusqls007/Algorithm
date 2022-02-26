import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw    = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st    = null;
		int             N     = Integer.parseInt(br.readLine());
		int[][]         arr   = new int[1002][1002];
		int[]           count = new int[N + 1];
		int             cnt   = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cnt++;

			int x      = Integer.parseInt(st.nextToken());
			int y      = Integer.parseInt(st.nextToken());
			int width  = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			for (int j = y; j < y + height; j++) {
				for (int k = x; k < x + width; k++) {
					arr[j][k] = cnt;
				}
			}
		}

		for (int i = 0; i < 1002; i++) {
			for (int j = 0; j < 1002; j++) {
				count[arr[i][j]]++;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			bw.write(String.format("%d\n", count[i]));
		}

		bw.flush();
	}
}
