import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
	static Map<Integer, String> move = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map[0][0] = 1;
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			move.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(0);
		int y = 0;
		int x = 0;
		int dir = 1;
		int time = 0;
		while (true) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			time++;
			
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > N - 1)
				break;
			if (dq.contains(ny * N + nx))
				break;

			dq.offerLast(ny * N + nx);
			if (map[ny][nx] == 2) {
				map[ny][nx] = 0;
			} else {
				dq.pollFirst();
			}

			if (move.containsKey(time)) {
				if (move.get(time).equals("D")) {
					dir += 1;
					dir %= 4;
				} else {
					dir -= 1;
					if (dir < 0)
						dir = 3;
				}
			}

			y = ny;
			x = nx;
		}
		System.out.println(time);
	}
}
