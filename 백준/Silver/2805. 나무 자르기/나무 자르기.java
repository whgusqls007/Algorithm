import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];

		st = new StringTokenizer(br.readLine());

		int max = -1;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (trees[i] > max) {
				max = trees[i];
			}
		}
		int start = 0;
		int middle = 0;
		int end = max;

		while (start <= end) {
			middle = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (trees[i] >= middle) {
					sum += trees[i] - middle;
				}
			}

			if (sum >= M) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		System.out.println(end);
	}
}
