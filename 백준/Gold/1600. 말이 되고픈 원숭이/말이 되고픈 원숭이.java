import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][]       map;
	static boolean[][][] visit;
	static int           H;
	static int           W;
	static int           K;
	static int[]         dy  =
		{
				-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2
		};
	static int[]         dx  =
		{
				0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1
		};
	static int           min = Integer.MAX_VALUE;

	public static void main( String[] args )
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader( System.in )
		);

		K = Integer.parseInt( br.readLine() );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		W     = Integer.parseInt( st.nextToken() );
		H     = Integer.parseInt( st.nextToken() );

		map   = new int[H][W];
		visit = new boolean[K + 1][H][W];

		for ( int i = 0; i < H; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < W; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		bfs();

		System.out.println( min == Integer.MAX_VALUE ? -1 : min );
	}

	static void bfs() {
		Deque< int[] > dq = new ArrayDeque< int[] >();
		dq.offerLast( new int[]
			{
					0, 0, 0, 0
			} );
		visit[0][0][0] = true;
		while ( !dq.isEmpty() ) {
			int[] tmp = dq.pollFirst();
			int   y   = tmp[0];
			int   x   = tmp[1];
			int   cnt = tmp[2];
			int   k   = tmp[3];
			if ( y == H - 1 && x == W - 1 ) {
				min = Math.min( min, cnt );
				continue;
			}
			if ( cnt + 1 >= min ) continue;
			for ( int i = 0; i < 4; i++ ) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if ( ny < 0 || ny > H - 1 || nx < 0 || nx > W - 1 ) continue;
				if ( visit[k][ny][nx] ) continue;
				if ( map[ny][nx] == 1 ) continue;
				visit[k][ny][nx] = true;
				dq.offerLast( new int[]
					{
							ny, nx, cnt + 1, k
					} );
			}

			if ( k >= K ) continue;

			for ( int i = 4; i < 12; i++ ) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if ( ny < 0 || ny > H - 1 || nx < 0 || nx > W - 1 ) continue;
				if ( visit[k + 1][ny][nx] ) continue;
				if ( map[ny][nx] == 1 ) continue;
				visit[k + 1][ny][nx] = true;
				dq.offerLast( new int[]
					{
							ny, nx, cnt + 1, k + 1
					} );
			}
		}
	}
}