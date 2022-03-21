import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main( String[] args ) throws IOException {
		char[] arr = ( new BufferedReader( new InputStreamReader( System.in ) ) ).readLine()
				.toCharArray();

		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr.length; j++ ) {
				if ( arr[i] > arr[j] ) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for ( char c : arr ) {
			System.out.print( c );
		}
	}
}
