import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader      br    = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer     st    = new StringTokenizer(br.readLine());
		StringBuilder       sb    = new StringBuilder();
		LinkedList<Integer> ll    = new LinkedList<>();
		ArrayDeque<Integer> dq    = new ArrayDeque<>();
		int                 N     = Integer.parseInt(st.nextToken());
		int                 K     = Integer.parseInt(st.nextToken());
		int                 index = 0;
		int                 cnt   = 0;

		for (int i = 0; i < N; i++) {
			// ll.add(i + 1);
			dq.offerLast(i + 1);
		}
		sb.append("<");
		while (!dq.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				dq.offerLast(dq.pollFirst());
			}
			sb.append(dq.pollFirst()).append(", ");
		}
		// while (ll.size() != 0) {
		// cnt++;
		// if (cnt % K == 0) {
		// sb.append(ll.get(index)).append(", ");
		// ll.remove(index % N);
		// cnt = 0;
		// } else {
		// index++;
		// }
		// if (index >= ll.size()) {
		// index = 0;
		// }
		// }
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
