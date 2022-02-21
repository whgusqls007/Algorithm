import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw    = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[]      visit = null;
	static int[][]        arr   = null;

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());
		int             V  = Integer.parseInt(st.nextToken());
		arr   = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			arr[y][x] = 1;
			arr[x][y] = 1;
		}
		dfs(V, N);

		Arrays.fill(visit, false);
		bw.write("\n");

		bfs(V, N);

		bw.flush();
	}

	static void dfs(int node, int N) throws IOException {
		visit[node] = true;
		bw.write(node + " ");
		for (int i = 1; i < N + 1; i++) {
			if (arr[node][i] == 1 && !visit[i]) {
				dfs(i, N);
			}
		}
	}

	static void bfs(int node, int N) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visit[node] = true;
		while (!q.isEmpty()) {
			int nodeN = q.poll();
			bw.write(nodeN + " ");
			for (int i = 1; i < N + 1; i++) {
				if (arr[nodeN][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
