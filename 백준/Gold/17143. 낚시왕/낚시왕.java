import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
	int r, c, s, d, z;

	public Shark( int r, int c, int s, int d, int z ) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

}

public class Main {
	static int R, C, M;

	public static void main( String[] args ) throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );

		R = Integer.parseInt( st.nextToken() );
		C = Integer.parseInt( st.nextToken() );
		M = Integer.parseInt( st.nextToken() );

		if ( M == 0 ) {
			System.out.println( 0 );
			System.exit( 0 );
		}

		Shark[][] sharks = new Shark[R + 1][C + 1];

		for ( int i = 0; i < M; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int r = Integer.parseInt( st.nextToken() );
			int c = Integer.parseInt( st.nextToken() );

			sharks[r][c] = new Shark(
					r,
					c,
					Integer.parseInt( st.nextToken() ),
					Integer.parseInt( st.nextToken() ),
					Integer.parseInt( st.nextToken() )
			);
		}
		int sum = 0;

		for ( int i = 1; i <= C; i++ ) {
			// 낚시
			for ( int j = 1; j <= R; j++ ) {
				if ( sharks[j][i] != null ) {
					sum          += sharks[j][i].z;
					sharks[j][i]  = null;
					break;
				}
			}

			// 상어 이동
			Shark[][] sharks2 = new Shark[R + 1][C + 1];

			for ( int j = 1; j <= R; j++ ) {
				for ( int k = 1; k <= C; k++ ) {

					if ( sharks[j][k] != null ) {
						int dir   = sharks[j][k].d;
						int speed = sharks[j][k].s;
						int y     = sharks[j][k].r;
						int x     = sharks[j][k].c;
						int ty    = y;
						int tx    = x;
						int ny    = y;
						int nx    = x;

						for ( int l = 0; l < speed; l++ ) {
							if ( dir == 1 ) { // 위
								ny = ty - 1;
								if ( ny < 1 ) {
									dir = 2;
									ny  = ty + 1;
								}
							} else if ( dir == 2 ) { // 아래
								ny = ty + 1;
								if ( ny > R ) {
									dir = 1;
									ny  = ty - 1;
								}
							} else if ( dir == 3 ) { // 오
								nx = tx + 1;
								if ( nx > C ) {
									dir = 4;
									nx  = tx - 1;
								}
							} else { // 왼
								nx = tx - 1;
								if ( nx < 1 ) {
									dir = 3;
									nx  = tx + 1;
								}
							}

							ty = ny;
							tx = nx;
						}

						if ( sharks2[ty][tx] != null ) {
							if ( sharks2[ty][tx].z < sharks[y][x].z ) {
								sharks2[ty][tx] = new Shark(
										ty,
										tx,
										speed,
										dir,
										sharks[y][x].z
								);
							}
						} else {
							sharks2[ty][tx] = new Shark(
									ty,
									tx,
									speed,
									dir,
									sharks[y][x].z
							);
						}
					}
				}
			}

			for ( int j = 1; j <= R; j++ ) {
				for ( int k = 1; k <= C; k++ ) {
					sharks[j][k] = sharks2[j][k];
				}
			}
		}
		System.out.println( sum );
	}
}
