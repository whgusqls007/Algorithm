import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long total, sum;
	static long[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new long[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			total += arr[i][1];
		}
		
		Arrays.sort(arr, (e1, e2) -> Long.compare(e1[0], e2[0]));
		
		for(int i = 0; i < N; i++) {
			sum += arr[i][1];
			if(sum >= (total + 1) / 2) {
				System.out.println(arr[i][0]);
				break;
			}
		}
	}
}
