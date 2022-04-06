import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static int            N;
	static int[][]        map;
	static int[]          population;
	static boolean[]      visit;
	static int            min;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		init();

		selectRedBlue( 0, 0 );

		System.out.println( min == Integer.MAX_VALUE ? -1 : min );
	}

	static void selectRedBlue( int index, int num ) {
		// 선택을 다 했으면
		if ( index == N ) {

			// 모두 빨간색이거나 모두 파란색이면 안됨
			if ( !checkColor( num ) ) return;

			// 색이 섞여 있다면 dfs로 연결돼 있는지 확인
			if ( checkConnection( num ) ) {
				// 확인했으면 시민들 차이 구하기
				min = Math.min( min, getPopSub( num ) );
			}

			return;
		}

		// index 마을이 파란색일때
		selectRedBlue( index + 1, num | ( 1 << index ) );

		// index 마을이 빨간색일때
		selectRedBlue( index + 1, num );
	}

	static int getPopSub( int num ) {
		int bp = 0;
		int rp = 0;
		for ( int i = 0; i < N; i++ ) {
			if ( ( num & 1 << i ) != 0 ) {
				bp += population[i];
			} else {
				rp += population[i];
			}
		}
		return Math.abs( bp - rp );
	}

	static boolean checkConnection( int num ) {
		int r = 0;
		int b = 0;

		for ( int i = 0; i < N; i++ ) {
			if ( ( num & ( 1 << i ) ) != 0 ) {
				b = checkBlueConnection( i, 1 << i, num );
				break;
			}
		}

		for ( int i = 0; i < N; i++ ) {
			if ( ( num & ( 1 << i ) ) == 0 ) {
				r = checkRedConnection( i, 1 << i, num );
				break;
			}
		}

		if ( r + b == ( 1 << N ) - 1 ) {
			return true;
		}

		return false;
	}

	static int checkRedConnection( int index, int bit, int num ) {
		int newBit = 0;
		for ( int j = 0; j < N; j++ ) {
			// index와 j 가 연결 되어 있고
			if ( map[index][j] != 0 ) {
				// j 가 빨간색이고
				if ( ( num & ( 1 << j ) ) == 0 ) {
					// 아직 방문 안했을 때
					if ( ( bit & ( 1 << j ) ) == 0 ) {
						newBit |= bit | checkRedConnection( j, bit | ( 1 << j ), num );
					}
				}
			}
		}

		return newBit == 0 ? bit : newBit;
	}

	static int checkBlueConnection( int index, int bit, int num ) {
		int newBit = 0;
		for ( int j = 0; j < N; j++ ) {
			// index와 j 가 연결 되어 있고
			if ( map[index][j] != 0 ) {
				// j 가 파란색이고
				if ( ( num & ( 1 << j ) ) != 0 ) {
					// 아직 방문 안했을 때
					if ( ( bit & ( 1 << j ) ) == 0 ) {
						newBit |= bit | checkBlueConnection( j, bit | ( 1 << j ), num );
					}
				}
			}
		}

		return newBit == 0 ? bit : newBit;
	}

	static boolean checkColor( int num ) {
		if ( num == ( 1 << N ) - 1 ) {
			return false;
		} else if ( num == 0 ) {
			return false;
		}
		return true;
	}

	static void init() throws NumberFormatException, IOException {
		br         = new BufferedReader( new InputStreamReader( System.in ) );
		N          = Integer.parseInt( br.readLine() );
		map        = new int[N][N];
		population = new int[N];
		min        = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer( br.readLine() );

		for ( int i = 0; i < N; i++ ) {
			population[i] = Integer.parseInt( st.nextToken() );
		}

		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int n = Integer.parseInt( st.nextToken() );

			for ( int j = 0; j < n; j++ ) {
				int num = Integer.parseInt( st.nextToken() );
				map[i][num - 1] = 1;
			}
		}

		br.close();
	}
}
