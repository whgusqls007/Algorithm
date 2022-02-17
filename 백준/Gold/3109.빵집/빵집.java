import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr = null;
	static int      N   = 0;
	static int      R   = 0;
	static int      C   = 0;
	static int      cnt = 0;
	static int[]    dy  =
		{
				-1, 0, 1
		};

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R   = Integer.parseInt(st.nextToken());
		C   = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			if(pipe(i, 0)) {
				cnt++;
			};
		}

		System.out.println(cnt);
	}

	public static boolean pipe(int y, int x) {
		if(x == C - 1) {
			return true;
		}
		int nx = x + 1;
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];

			if (ny >= 0 && ny <= R - 1 && arr[ny][nx] == '.') {
				arr[ny][nx] = '~';
				if (pipe(ny, nx)) {
					return true;
				}
			}
		}
		return false;
	}
}
