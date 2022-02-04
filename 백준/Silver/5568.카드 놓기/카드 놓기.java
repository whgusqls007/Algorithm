
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static String[][] result = null;
	static int        N      = 0;
	static int        K      = 0;
	static int        index  = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		int nfac  = 1;
		int kfac  = 1;
		int nkfac = 1;
		int max   = -1;

		for (int i = N; i > 0; i--) {
			nfac *= i;
		}

		for (int i = K; i > 0; i--) {
			kfac *= i;
		}

		for (int i = N - K; i > 0; i--) {
			nkfac *= i;
		}

		result = new String[nfac / nkfac][K];
		int[]     arr     = new int[nfac / nkfac];

		String[]  card    = new String[N];
		boolean[] visit   = new boolean[N];
		String[]  cardSet = new String[K];

		for (int i = 0; i < N; i++) {
			card[i] = br.readLine();
		}

		permutation(card, cardSet, visit, 0, N, K);

		int index = 0;
		int cnt   = 0;
		for (int i = 0; i < result.length; i++) {
			String temp = "";
			for (int j = 0; j < result[i].length; j++) {
				temp += result[i][j];
			}
			int     num = Integer.parseInt(temp);
			boolean aaa = false;
			for (int j = 0; j < arr.length; j++) {
				if (num == arr[j]) {
					aaa = true;
					break;
				}
			}
			if (!aaa) {
				arr[index++] = num;
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	static void permutation(String[] card, String[] cardSet, boolean visit[], int depth, int n,
			int r) {
		if (depth == r) {
			result[index] = cardSet.clone();
			index++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i] != true) {
				visit[i]       = true;
				cardSet[depth] = card[i];
				permutation(card, cardSet, visit, depth + 1, n, r);
				visit[i] = false;
			}
		}
	}

}
