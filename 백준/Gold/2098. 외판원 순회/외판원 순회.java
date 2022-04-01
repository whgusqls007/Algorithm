import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 외판원 순회
// 다이나믹 프로그래밍
public class Main {
	static int       n;
	static int[][]   map;
	static int[][]   dp;
	static final int INF = 11000000; // MAX : 11,000,000

	public static void main( String args[] ) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		n   = Integer.valueOf( br.readLine() );
		map = new int[n][n];
		// i : 현재 위치한 도시, j : 지금까지 방문한 도시 2진수
		dp  = new int[n][( 1 << n ) - 1];      // ex) 1 << 5 = 100000(2) = 32 -> 우리의 최대값 : 11111(2) 이므로
																						// 1 빼기

		// 1) Map 입력받아 대입하기
		StringTokenizer st;
		for ( int i = 0; i < n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < n; j++ ) {
				int weight = Integer.valueOf( st.nextToken() );
				map[i][j] = weight;
			}
		}

		// dp배열 초기화
		for ( int i = 0; i < n; i++ ) {
			Arrays.fill( dp[i], INF );
		}

		System.out.println( dfs( 0, 1 ) );
	}

	// 어느 도시에서 시작하든지 최소비용은 같기 때문에 편안하게 0번도시부터 시작하자
	// @param: city - 현재 위치한 도시 인덱스, visitBitMask - 지금까지 방문한 도시 2진수
	// DFS 알고리즘
	private static int dfs( int city, int visitBitmask ) {

		if ( visitBitmask == ( 1 << n ) - 1 ) { // 모든 도시를 방문했다면
			if ( map[city][0] == 0 ) { // 이런 경우는 거의 없겠지만, 혹시 발생하는 경우 예외 처리
				return INF;
			}

			return map[city][0]; // 현재 도시 -> 0번쨰(시작) 도시 이동 거리
		}

		if ( dp[city][visitBitmask] != INF ) { // dp값이 존재하는경우
			return dp[city][visitBitmask];
		}

		for ( int i = 0; i < n; i++ ) { // 현재 도시(city)에서 각 i의 도시로 이동한 경우에 대해 DFS 수행
			if ( ( visitBitmask & ( 1 << i ) ) == 0 && map[city][i] != 0 ) { // 한 번이라도 그 도시를 방문했는데 다시 그
																																				// 도시를 방문하는 경우 예외처리
				// d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때, 방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로
				// 돌아올 때 드는 최소 비용.
				// 즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용
				dp[city][visitBitmask] = Math
						.min( dp[city][visitBitmask], dfs( i, visitBitmask | ( 1 << i ) ) + map[city][i] ); // dfs(다음																																												// 비교
			}
		}

		return dp[city][visitBitmask];
	}
}
