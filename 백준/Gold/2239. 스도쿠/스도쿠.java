import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[][]        map;
	static int            zeroCount;
	static boolean        isFinished;

	public static void main( String[] args ) throws IOException {
		init();
		dfs( 0, 0 );

		bw.flush();
		bw.close();
	}

	static void init() throws IOException {
		br         = new BufferedReader( new InputStreamReader( System.in ) );
		map        = new int[9][9];
		zeroCount  = 0;
		isFinished = false;

		for ( int i = 0; i < 9; i++ ) {
			String input = br.readLine();
			for ( int j = 0; j < 9; j++ ) {
				map[i][j] = Integer.parseInt( String.valueOf( input.charAt( j ) ) );
				if ( map[i][j] == 0 ) zeroCount++;
			}
		}

		br.close();
	}

	static void dfs( int i, int j ) throws IOException {
		if ( zeroCount == 0 ) {
			print();
			isFinished = true;
			return;
		}

		if ( map[i][j] != 0 ) {
			dfs( j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1 );
			return;
		}

		for ( int num = 1; num < 10; num++ ) {
			if ( !checkRow( j, num ) ) continue;
			if ( !checkColumn( i, num ) ) continue;
			if ( !checkBox( i, j, num ) ) continue;
			map[i][j] = num;
			zeroCount--;
			dfs( j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1 );

			if ( isFinished ) return;

			map[i][j] = 0;
			zeroCount++;
		}

	}

	static void print() throws IOException {
		bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		for ( int[] arr : map ) {
			for ( int elem : arr ) {
				bw.write( String.format( "%d", elem ) );
			}
			bw.write( "\n" );
		}
	}

	static boolean checkRow( int j, int num ) {
		boolean result = true;
		for ( int i = 0; i < 9; i++ ) {
			if ( map[i][j] == num ) {
				result = false;
				break;
			}
		}
		return result;
	}

	static boolean checkColumn( int i, int num ) {
		boolean result = true;
		for ( int j = 0; j < 9; j++ ) {
			if ( map[i][j] == num ) {
				result = false;
				break;
			}
		}
		return result;
	}

	static boolean checkBox( int index, int jndex, int num ) {
		boolean result = true;
		int     startI = ( index / 3 ) * 3;
		int     startJ = ( jndex / 3 ) * 3;

		breakPoint : for ( int i = startI; i < startI + 3; i++ ) {
			for ( int j = startJ; j < startJ + 3; j++ ) {
				if ( map[i][j] == num ) {
					result = false;
					break breakPoint;
				}
			}
		}

		return result;
	}
}
