import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int            R;
	static int            C;
	static int[]          dy;
	static int[]          dx;
	static char[][]       map;
	static Deque< int[] > dq = new ArrayDeque<>();

	public static void main( String[] args ) throws Exception {
		BufferedReader  br = new BufferedReader(
				new InputStreamReader( System.in )
		);
		StringTokenizer st = new StringTokenizer( br.readLine() );
		R = Integer.parseInt( st.nextToken() );
		C = Integer.parseInt( st.nextToken() );
		int T    = 0;
		int size = 0;

		map = new char[R][C];
		dy  = new int[]
			{
					-1, 0, 1, 0
			};
		dx  = new int[]
			{
					0, 1, 0, -1
			};

		for ( int i = 0; i < R; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < C; j++ ) {
				int num = Integer.parseInt( st.nextToken() );
				if ( num == 1 ) {
					size++;
					map[i][j] = 'c';
				}
			}
		}

		br.close();

		int lastSize = 0;
		bfs( 0, 0 );

		while ( size != 0 ) {

			lastSize = size;
			T++;
			for ( int i = 0; i < R; i++ ) {
				for ( int j = 0; j < C; j++ ) {
					if ( map[i][j] == 'c' ) {
						for ( int k = 0; k < 4; k++ ) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if ( ny < 0 || ny > R - 1 || nx < 0 || nx > C - 1 ) continue;
							if ( map[ny][nx] == 'a' ) {
								map[i][j] = 'b';
								size--;
								break;
							}
						}
					}
				}
			}
			for ( int i = 0; i < R; i++ ) {
				for ( int j = 0; j < C; j++ ) {
					if ( map[i][j] == 'b' ) {
						bfs( i, j );
					}
				}
			}
		}
		System.out.println( T );
		System.out.println( lastSize );
	}

	static void bfs( int i, int j ) {
		int         ny    = 0;
		int         nx    = 0;
		int[]       coord = null;
		boolean[][] visit = new boolean[R][C];
		dq.offerLast( new int[]
			{
					i, j
			} );
		visit[i][j] = true;
		while ( !dq.isEmpty() ) {
			coord                   = dq.pollFirst();
			map[coord[0]][coord[1]] = 'a';

			for ( int k = 0; k < 4; k++ ) {
				ny = coord[0] + dy[k];
				nx = coord[1] + dx[k];

				if ( ny < 0 || ny > R - 1 || nx < 0 || nx > C - 1 ) continue;
				if ( map[ny][nx] == 'c' || map[ny][nx] == 'a' ) continue;
				if ( visit[ny][nx] ) continue;
				visit[ny][nx] = true;
				dq.offerLast( new int[]
					{
							ny, nx
					} );
			}
		}
	}
}
