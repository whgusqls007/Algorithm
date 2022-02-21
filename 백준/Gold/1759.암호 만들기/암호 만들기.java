import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int            L      = 0;
	static int            C      = 0;
	static char[]         arr    = null;
	static char[]         result = null;
	static BufferedWriter bw     = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L      = Integer.parseInt(st.nextToken());
		C      = Integer.parseInt(st.nextToken());
		result = new char[L];
		arr    = new char[C];

		int index = 0;
		for (String str : br.readLine().split(" ")) {
			arr[index++] = str.charAt(0);
		}

		Arrays.sort(arr);

		dfs(0, 0, 0);
		bw.flush();
	}

	public static void dfs(int depth, int bit, int start) throws Exception {
		if (depth == L) {
			if (!count()) return;

			for (int i = 0; i < L; i++) {
				bw.write(String.format("%c", result[i]));
			}
			bw.write("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			if ((bit & 1 << i) != 0) continue;
			result[depth] = arr[i];
			dfs(depth + 1, bit | 1 << i, i);
		}
	}

	public static boolean count() {
		boolean[] alphabet = new boolean[27];
		int       C        = 0;
		int       V        = 0;
		for (int i = 0; i < L; i++) {
			if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o'
					|| result[i] == 'u') {

				if (!alphabet[result[i] - 'a']) {
					alphabet[result[i] - 'a'] = true;
					V++;
				}
			} else {
				if (!alphabet[result[i] - 'a']) {
					alphabet[result[i] - 'a'] = true;
					C++;
				}
			}
			if (V >= 1 && C >= 2) {
				return true;
			}
		}
		return false;
	}
}