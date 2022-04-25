import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Number {
	int    n;
	String str;

	public Number( int n, String str ) {
		super();
		this.n   = n;
		this.str = str;
	}

}

public class Main {
	public static void main( String[] args ) throws IOException {
		StringTokenizer         st     = new StringTokenizer(
				new BufferedReader( new InputStreamReader( System.in ) ).readLine()
		);
		int                     M      = Integer.parseInt( st.nextToken() );
		int                     N      = Integer.parseInt( st.nextToken() );
		PriorityQueue< Number > pq     = new PriorityQueue<>( ( c1, c2 ) -> {
																			int a = c1.str.compareTo( c2.str );
																			return a;
																		} );                                                // 우선순위 큐에
																																												// 스트링 순서로
																																												// 소팅함

		String[]                strArr =
			{
					"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
			};

		StringBuilder           sb     = new StringBuilder();

		for ( int i = M; i <= N; i++ ) {
			if ( i / 10 != 0 ) {
				sb.append( strArr[i / 10] ).append( " " );
			}
			sb.append( strArr[i % 10] );
			pq.add(
					new Number(
							i,
							sb.toString()
					)
			);
			sb.setLength( 0 );
		}

		BufferedWriter bw  = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int            cnt = 0;
		while ( !pq.isEmpty() ) {
			bw.write( String.format( "%d ", pq.poll().n ) );
			cnt++;
			if ( cnt == 10 ) {
				cnt = 0;
				bw.write( "\n" );
			}
		}

		bw.flush();
	}
}
