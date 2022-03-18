import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][]             color;
	static int[][]             piece;
	static List< Integer >[][] board;

	public static void main( String[] args ) throws Exception {
		BufferedReader  br    = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st    = new StringTokenizer( br.readLine() );
		int             N     = Integer.parseInt( st.nextToken() );
		int             K     = Integer.parseInt( st.nextToken() );
		int             count = 0;

		color = new int[N][N];
		piece = new int[K][3];
		board = new ArrayList[N][N];

		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ ) {
				board[i][j] = new ArrayList< Integer >();
			}
		}

		// 체스 판 정보
		// 0 흰, 1 빨, 2 파
		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < N; j++ ) {
				color[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		// 체스 말 정보
		// 1 우, 2 좌, 3 상, 4 하
		for ( int i = 0; i < K; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int y   = Integer.parseInt( st.nextToken() ) - 1;
			int x   = Integer.parseInt( st.nextToken() ) - 1;
			int dir = Integer.parseInt( st.nextToken() );
			piece[i][0] = y;
			piece[i][1] = x;
			piece[i][2] = dir;
			board[y][x].add( i );
		}

		outer : while ( true ) {
			count++;
			if ( count > 1000 ) {
				System.out.println( -1 );
				return;
			}
			for ( int i = 0; i < K; i++ ) {
				int y     = piece[i][0];
				int x     = piece[i][1];
				int dir   = piece[i][2];
				int index = board[y][x].indexOf( i );
				int ny    = 0;
				int nx    = 0;
				if ( board[y][x].size() >= 4 ) {
					break outer;
				}
				// 우
				if ( dir == 1 ) {
					ny = y;
					nx = x + 1;
					// 이동하려는 칸이 범위가 벗어나거나 파란색인 경우
					if ( nx > N - 1 || color[ny][nx] == 2 ) {
						dir = changeDir( dir );
						ny  = y;
						nx  = x - 1;

						// 반대도 파란색이면 그자리에 멈춤
						if ( nx < 0 || color[ny][nx] == 2 ) {
							piece[i][2] = dir;
						}

						// 반대가 빨간색이면?
						// 움직인 말들은 순서 바꿔줘야함
						else if ( color[ny][nx] == 1 ) {
							piece[i][2] = dir;
							red( y, x, ny, nx, index, dir );
						}

						// 흰색이면?
						else {
							piece[i][2] = dir;
							white( y, x, ny, nx, index, dir );
						}
					}
					// 빨갱이
					else if ( color[ny][nx] == 1 ) {
						piece[i][2] = dir;
						red( y, x, ny, nx, index, dir );
					}

					// 흰
					else {
						piece[i][2] = dir;
						white( y, x, ny, nx, index, dir );
					}
				}

				// 좌
				else if ( dir == 2 ) {
					ny = y;
					nx = x - 1;
					// 이동하려는 칸이 범위가 벗어나거나 파란색인 경우
					if ( nx < 0 || color[ny][nx] == 2 ) {
						dir = changeDir( dir );
						ny  = y;
						nx  = x + 1;

						// 반대도 파란색이면 그자리에 멈춤
						if ( nx > N - 1 || color[ny][nx] == 2 ) {
							piece[i][2] = dir;
						}

						// 반대가 빨간색이면?
						// 움직인 말들은 순서 바꿔줘야함
						else if ( color[ny][nx] == 1 ) {
							piece[i][2] = dir;
							red( y, x, ny, nx, index, dir );
						}

						// 흰색이면?
						else {
							piece[i][2] = dir;
							white( y, x, ny, nx, index, dir );
						}
					}
					// 빨갱이
					else if ( color[ny][nx] == 1 ) {
						piece[i][2] = dir;
						red( y, x, ny, nx, index, dir );
					}

					// 흰
					else {
						white( y, x, ny, nx, index, dir );
						piece[i][2] = dir;
					}
				}

				// 상
				else if ( dir == 3 ) {
					ny = y - 1;
					nx = x;
					// 이동하려는 칸이 범위가 벗어나거나 파란색인 경우
					if ( ny < 0 || color[ny][nx] == 2 ) {
						dir = changeDir( dir );
						ny  = y + 1;
						nx  = x;

						// 반대도 파란색이면 그자리에 멈춤
						if ( ny > N - 1 || color[ny][nx] == 2 ) {
							piece[i][2] = dir;
						}

						// 반대가 빨간색이면?
						// 움직인 말들은 순서 바꿔줘야함
						else if ( color[ny][nx] == 1 ) {
							piece[i][2] = dir;
							red( y, x, ny, nx, index, dir );
						}

						// 흰색이면?
						else {
							piece[i][2] = dir;
							white( y, x, ny, nx, index, dir );
						}
					}
					// 빨갱이
					else if ( color[ny][nx] == 1 ) {
						piece[i][2] = dir;
						red( y, x, ny, nx, index, dir );
					}

					// 흰
					else {
						piece[i][2] = dir;
						white( y, x, ny, nx, index, dir );
					}
				}

				// 하
				else {
					ny = y + 1;
					nx = x;
					// 이동하려는 칸이 범위가 벗어나거나 파란색인 경우
					if ( ny > N - 1 || color[ny][nx] == 2 ) {
						dir = changeDir( dir );
						ny  = y - 1;
						nx  = x;

						// 반대도 파란색이면 그자리에 멈춤
						if ( ny < 0 || color[ny][nx] == 2 ) {
							piece[i][2] = dir;
						}

						// 반대가 빨간색이면?
						// 움직인 말들은 순서 바꿔줘야함
						else if ( color[ny][nx] == 1 ) {
							piece[i][2] = dir;
							red( y, x, ny, nx, index, dir );
						}

						// 흰색이면?
						else {
							piece[i][2] = dir;
							white( y, x, ny, nx, index, dir );
						}
					}
					// 빨갱이
					else if ( color[ny][nx] == 1 ) {
						piece[i][2] = dir;
						red( y, x, ny, nx, index, dir );
					}

					// 흰
					else {
						piece[i][2] = dir;
						white( y, x, ny, nx, index, dir );
					}
				}

				if ( -1 < ny && ny < N && -1 < nx && nx < N && board[ny][nx].size() >= 4 ) {
					break outer;
				}
			}
		}

		System.out.println( count );
	}

	static void white( int y, int x, int ny, int nx, int index, int dir ) {
		for ( int k = index; k < board[y][x].size(); k++ ) {
			int num = board[y][x].get( k );
			board[ny][nx].add( num );
			board[y][x].remove( k-- );
			piece[num][0] = ny;
			piece[num][1] = nx;
		}
	}

	static void red( int y, int x, int ny, int nx, int index, int dir ) {
		for ( int k = board[y][x].size() - 1; k > index - 1; k-- ) {
			int num = board[y][x].get( k );
			board[ny][nx].add( num );
			board[y][x].remove( k );
			piece[num][0] = ny;
			piece[num][1] = nx;
		}
	}

	static int changeDir( int dir ) {
		if ( dir == 1 ) return 2;
		if ( dir == 2 ) return 1;
		if ( dir == 3 ) return 4;
		if ( dir == 4 ) return 3;
		return 0;
	}
}
