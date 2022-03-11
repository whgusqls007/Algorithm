import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main( String[] args ) throws Exception {
		BufferedReader  br    = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st    = new StringTokenizer( br.readLine() );
		int             N     = Integer.parseInt( st.nextToken() );
		int             K     = Integer.parseInt( st.nextToken() );
		int             count = 0;
		List< Integer > belt  = new ArrayList< Integer >();
		List< Boolean > robot = new ArrayList< Boolean >();

		st = new StringTokenizer( br.readLine() );

		for ( int i = 0; i < 2 * N; i++ ) {
			belt.add( Integer.parseInt( st.nextToken() ) );
		}

		for ( int i = 0; i < 2 * N; i++ ) {
			robot.add( false );
		}

		while ( true ) {
			// 종료 조건
			int zero = 0;
			for ( int i = 0; i < 2 * N; i++ ) {
				if ( belt.get( i ) == 0 ) {
					zero++;
				}
			}
			if ( zero >= K ) break;

			count++;

			// 벨트 회전
			belt.add( 0, belt.get( 2 * N - 1 ) );
			belt.remove( 2 * N );

			// 로봇 회전시키고 끝에 왔으면 내려줌
			robot.add( 0, robot.get( 2 * N - 1 ) );
			robot.remove( 2 * N );
			if ( robot.get( N ) == true ) robot.set( N, false );

			// 앞에서부터 로봇들 한칸씩 전진
			for ( int i = N - 1; i > -1; i-- ) {
				// 마지막 칸에 로봇이 있을때
				if ( i == N - 1 && robot.get( i ) == true ) {
					// 로봇을 내림
					robot.set( i, false );
				}
				// 마지막 칸이 아닌데 로봇이 있을때
				else if ( i != N - 1 && robot.get( i ) == true ) {
					// 벨트의 다음칸 내구도가 남아있고 다음칸에 로봇이 없으면 이동
					if ( belt.get( i + 1 ) > 0 && !robot.get( i + 1 ) ) {
						// 내구도 감소
						belt.set( i + 1, belt.get( i + 1 ) - 1 );
						// 로봇 이동
						robot.set( i + 1, true );
						robot.set( i, false );
					}
				}
			}

			// 맨 앞칸의 내구도가 0이 아니고 로봇이 없다면 로봇을 올림
			if ( belt.get( 0 ) > 0 && !robot.get( 0 ) ) {
				belt.set( 0, belt.get( 0 ) - 1 );
				robot.set( 0, true );
			}
		}

		System.out.println( count );
	}
}