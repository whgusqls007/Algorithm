import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int position = 0, min = 0;
		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < N + 1; i++) {
			if (arr[i] == 0) {
				position = i;
				break;
			}
		}

		for (int i = 0; i < position; i += M)
			min += Math.abs(arr[i] * 2);

		for (int i = N; i > position; i -= M)
			min += arr[i] * 2;
		
		min -= Math.max(Math.abs(arr[0]), Math.abs(arr[N]));
		
		System.out.println(min);
	}
}
