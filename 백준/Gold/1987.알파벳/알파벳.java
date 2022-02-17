import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             R   = Integer.parseInt(st.nextToken());
		int             C   = Integer.parseInt(st.nextToken());
		char[][]        arr = new char[R][];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int result = dfs(1, 1 << arr[0][0] - 'A', new int[]
			{
					-1, 0, 1, 0
			}, new int[]
			{
					0, 1, 0, -1
			}, 0, 0, R, C, arr);

		System.out.println(result);
	}

	public static int dfs(int depth, int bit, int[] dy, int[] dx, int y, int x, int R, int C,
			char[][] arr) {
		int     d    = 0;
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1) continue; // 범위 벗어남
			if (arr[ny][nx] == arr[y][x]) continue; // 다음게 현재꺼랑 같음
			if ((bit & 1 << arr[ny][nx] - 'A') != 0) continue; // 이전에 썼던 알파벳
			flag = true;
			int tmp = dfs(depth + 1, bit | 1 << arr[ny][nx] - 'A', dy, dx, ny, nx, R, C, arr);
			d = d < tmp ? tmp : d;
		}
		return flag ? d : depth;
	}
}