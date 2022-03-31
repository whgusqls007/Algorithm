import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main( String[] args )
			throws NumberFormatException, IOException {
		int   N   = Integer.parseInt(
				new BufferedReader( new InputStreamReader( System.in ) ).readLine()
		);

		int[] arr = new int[N + 1];
		arr[0] = 0;
		arr[1] = 0;

		for ( int i = 2; i < N + 1; i++ ) {
			arr[i] = Integer.MAX_VALUE;
		}

		for ( int i = 2; i < N + 1; i++ ) {
			if ( i % 3 == 0 ) {
				arr[i] = Math.min( arr[i], arr[i / 3] + 1 );
			}
			if ( i % 2 == 0 ) {
				arr[i] = Math.min( arr[i], arr[i / 2] + 1 );
			}
			arr[i] = Math.min( arr[i], arr[i - 1] + 1 );

		}

		System.out.println( arr[N] );
	}
}
