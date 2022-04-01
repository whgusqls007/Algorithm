import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main( String[] args ) throws IOException {
		BufferedReader  br    = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st    = new StringTokenizer( br.readLine() );
		int             N     = Integer.parseInt( st.nextToken() );
		int             M     = Integer.parseInt( st.nextToken() );
		char[][]        map   = new char[N][M];
		boolean[][][]   visit = new boolean[65][N][M];
		Deque< int[] >  dq    = new ArrayDeque<>();
		int[]           dy    =
			{
					-1, 0, 1, 0
			};
		int[]           dx    =
			{
					0, 1, 0, -1
			};
		int             min   = Integer.MAX_VALUE;

		for ( int i = 0; i < N; i++ ) {
			map[i] = br.readLine().toCharArray();
			for ( int j = 0; j < M; j++ ) {
				if ( map[i][j] == '0' ) {
					visit[0][i][j] = true;
					dq.offerLast( new int[]
						{
								i, j, 0, 0
						} );
				}
			}
		}

		while ( !dq.isEmpty() ) {
			int[] tmp   = dq.pollFirst();
			int   y     = tmp[0];
			int   x     = tmp[1];
			int   keys  = tmp[2];
			int   count = tmp[3];

			if ( count >= min ) {
				continue;
			}

			if ( map[y][x] == '1' ) {
				min = Math.min( count, min );
				continue;
			}

			for ( int i = 0; i < 4; i++ ) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if ( ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 ) continue;
				if ( map[ny][nx] == '#' ) continue;

				char nb = map[ny][nx];

				if ( nb == '.' || nb == '0' || nb == '1' ) {
					if ( visit[keys][ny][nx] ) continue;
					visit[keys][ny][nx] = true;
					dq.offerLast( new int[]
						{
								ny, nx, keys, count + 1
						} );
				}

				else if ( nb == 'A' || nb == 'B' || nb == 'C' || nb == 'D' || nb == 'E' || nb == 'F' ) {
					if ( checkKeys( nb, keys ) ) {
						if ( !visit[keys][ny][nx] ) {
							visit[keys][ny][nx] = true;
							dq.offerLast( new int[]
								{
										ny, nx, keys, count + 1
								}
							);
						}
					}
				} else if ( nb == 'a' || nb == 'b' || nb == 'c' || nb == 'd' || nb == 'e' || nb == 'f' ) {
					int newKeys = getKeys( nb, keys );
					if ( visit[newKeys][ny][nx] ) continue;
					visit[newKeys][ny][nx] = true;
					dq.offerLast( new int[]
						{
								ny, nx, newKeys, count + 1
						}
					);
				}
			}
		}
		System.out.println( min == Integer.MAX_VALUE ? -1 : min );
	}

	static int getKeys( char nb, int keys ) {
		switch ( nb ) {
			case 'a':
				return keys = keys | 1;
			case 'b':
				return keys = keys | ( 1 << 1 );
			case 'c':
				return keys = keys | ( 1 << 2 );
			case 'd':
				return keys = keys | ( 1 << 3 );
			case 'e':
				return keys = keys | ( 1 << 4 );
			case 'f':
				return keys = keys | ( 1 << 5 );
		}
		return keys;
	}

	static boolean checkKeys( char nb, int keys ) {
		switch ( nb ) {
			case 'A':
				if ( ( keys & 1 ) == 1 ) {
					return true;
				}
				break;
			case 'B':
				if ( ( keys & ( 1 << 1 ) ) == 2 ) {
					return true;
				}
				break;
			case 'C':
				if ( ( keys & ( 1 << 2 ) ) == 4 ) {
					return true;
				}
				break;
			case 'D':
				if ( ( keys & ( 1 << 3 ) ) == 8 ) {
					return true;
				}
				break;
			case 'E':
				if ( ( keys & ( 1 << 4 ) ) == 16 ) {
					return true;
				}
				break;
			case 'F':
				if ( ( keys & ( 1 << 5 ) ) == 32 ) {
					return true;
				}
				break;
		}
		return false;
	}
}
