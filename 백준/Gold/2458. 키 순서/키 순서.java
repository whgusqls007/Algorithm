import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int     N;
	static int     M;
	static int[][] people;
	static int     INF = 100000;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader  br     = new BufferedReader( new InputStreamReader( System.in ) );
		//int             T      = Integer.parseInt( br.readLine() );
		int             answer = 0;

		StringTokenizer st     = new StringTokenizer( br.readLine() );
		N      = Integer.parseInt( st.nextToken() );
		M      = Integer.parseInt( st.nextToken() );

		people = new int[N][N];
		for ( int i = 0; i < N; i++ )
			Arrays.fill( people[i], INF );

		for ( int i = 0; i < M; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int from = Integer.parseInt( st.nextToken() ) - 1;
			int to   = Integer.parseInt( st.nextToken() ) - 1;
			people[from][to] = 1;
		}

		for ( int k = 0; k < N; k++ ) { // 경
			for ( int i = 0; i < N; i++ ) { // 출
				for ( int j = 0; j < N; j++ ) { // 도
					if ( k == i || i == j || k == j ) continue;
					people[i][j] = Math.min( people[i][j], people[i][k] + people[k][j] );
				}
			}
		}

		for ( int i = 0; i < N; i++ ) {
			boolean flag = true;
			for ( int j = 0; j < N; j++ ) {
				if ( i == j || people[i][j] != INF || people[j][i] != INF ) continue;
				flag = false;
				break;
			}
			if ( flag ) answer++;
		}
		System.out.println( answer );
	}
}
