import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings( "unchecked" )
public class Main {
	static int[][]                  map, copiedMap;
	static int                      N, M, D, totalCount, enemyCount, killedCount, maxKilled;
	static int[]                    comb;
	static PriorityQueue< int[] >[] pq;

	public static void main( String[] args ) throws IOException {
		init();
		while ( nextComb() ) {
			enemyCount  = totalCount;
			killedCount = 0;
			copyMap();

			while ( true ) {
				getDistanceQueue();

				for ( int i = 0; i < 3; i++ ) {
					int[] killedEnemy = pq[i].poll();

					if ( killedEnemy == null ) continue;

					int y = killedEnemy[0];
					int x = killedEnemy[1];
					if ( copiedMap[y][x] == 1 ) {
						copiedMap[y][x] = 0;
						killedCount++;
						enemyCount--;
					}
				}

				enemyMarch();

				if ( enemyCount < 1 ) {
					maxKilled = Math.max( maxKilled, killedCount );
					break;
				}
			}
		}

		System.out.println( maxKilled );
		return;
	}

	static void copyMap() {
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < M; j++ ) {
				copiedMap[i][j] = map[i][j];
			}
		}
	}

	static void enemyMarch() {
		for ( int i = N - 1; i > 0; i-- ) {
			for ( int j = M - 1; j > -1; j-- ) {
				if ( i == N - 1 && copiedMap[i][j] == 1 ) enemyCount--;
				copiedMap[i][j] = copiedMap[i - 1][j];
			}
		}

		for ( int i = 0; i < M; i++ ) {
			copiedMap[0][i] = 0;
		}
	}

	static void getDistanceQueue() {
		pq = new PriorityQueue[3];
		int archer = 0;

		for ( int i = 0; i < M; i++ ) {
			if ( comb[i] == 1 ) continue;

			pq[archer] = new PriorityQueue< int[] >( ( e1, e2 ) -> {
				int comp = Integer.compare( e1[2], e2[2] );
				if ( comp == 0 ) {
					return Integer.compare( e1[1], e2[1] );
				}
				return comp;
			} );

			for ( int j = 0; j < N; j++ ) {
				for ( int k = 0; k < M; k++ ) {
					if ( copiedMap[j][k] != 1 ) continue;
					int dist = getDist( j, k, N, i );
					if ( dist > D ) continue;
					pq[archer].offer( new int[]
						{
								j, k, getDist( j, k, N, i )
						} );
				}
			}

			archer++;
		}

		return;
	}

	static boolean nextComb() {
		if ( comb == null ) {
			comb = new int[M];
			for ( int i = 3; i < M; i++ ) {
				comb[i] = 1;
			}
			return true;
		}

		int i = M - 1;
		while ( i > 0 && comb[i - 1] >= comb[i] ) i--;
		if ( i == 0 ) return false;

		int j = M - 1;
		while ( comb[i - 1] >= comb[j] ) j--;

		swap( i - 1, j );

		int k = M - 1;

		while ( i < k ) swap( i++, k-- );

		return true;
	}

	static void swap( int i, int j ) {
		int temp = comb[i];
		comb[i] = comb[j];
		comb[j] = temp;
		return;
	}

	static int getDist( int x1, int y1, int x2, int y2 ) {
		return Math.abs( x1 - x2 ) + Math.abs( y1 - y2 );
	}

	static void init() throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		N           = Integer.parseInt( st.nextToken() );
		M           = Integer.parseInt( st.nextToken() );
		D           = Integer.parseInt( st.nextToken() );
		map         = new int[N][M];
		copiedMap   = new int[N][M];
		totalCount  = 0;
		killedCount = 0;
		maxKilled   = Integer.MIN_VALUE;

		// 초기 상태
		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < M; j++ ) {
				int num = Integer.parseInt( st.nextToken() );
				if ( num == 1 ) totalCount++;
				map[i][j] = num;
			}
		}

		br.close();
		return;
	}
}
