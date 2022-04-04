import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader  br  = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st  = null;
		int             N   = Integer.parseInt( br.readLine() );
		int[][]         pp  = new int[N][2];
		int[]           A   = new int[N];
		int[]           B   = new int[N];
		int[]           LIS = new int[N];
		int             max = Character.MIN_VALUE;
		int             len = 0;

		for ( int i = 0; i < N; i++ ) {
			st       = new StringTokenizer( br.readLine() );
			pp[i][0] = Integer.parseInt( st.nextToken() );
			pp[i][1] = Integer.parseInt( st.nextToken() );
		}

		Arrays.sort( pp, ( e1, e2 ) -> Integer.compare( e1[0], e2[0] ) );

		for ( int i = 0; i < N; i++ ) {
			A[i] = pp[i][0];
			B[i] = pp[i][1];
		}

		for ( int i = 0; i < N; i++ ) {
			int position = Math.abs( Arrays.binarySearch( LIS, 0, len, B[i] ) ) - 1;

			LIS[position] = B[i];

			if ( len == position ) len++;
		}

		System.out.println( N - len );
	}
}