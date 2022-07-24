import java.util.*;
import java.io.*;

public class Main {
	static int N, M, digit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		digit = N - M;

		String str = br.readLine();
		Deque<Character> dq = new ArrayDeque<>();
		dq.offerLast(str.charAt(0));

		for (int i = 1; i < str.length(); i++) {

			if (str.length() - i <= digit - dq.size()) {
				for (int j = i; j < str.length(); j++) {
					dq.offerLast(str.charAt(j));
				}
				break;
			}

			char number = str.charAt(i);

			while (!dq.isEmpty()) {
				if (dq.peekLast() < number) {
					dq.pollLast();
					if (dq.size() + str.length() - i == digit) {
						break;
					}
				} else {
					break;
				}
			}

			dq.offerLast(number);
		}

		StringBuilder sb = new StringBuilder();
		while (!dq.isEmpty() && sb.length() < digit) {
			sb.append(dq.pollFirst());
		}

		System.out.println(sb);
	}
}
