import java.io.*;

public class Main {
	static int dr[] = { 0, 0, 1 };
	static int dc[] = { -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(in.readLine());
		char map[][] = new char[n][n];
		int check[][] = new int[n][n];
		String tmp = in.readLine();
		for (int i = 0; i < n; i++) {
			map[0][i] = tmp.charAt(i);
			sb.append(map[0][i]);
		}
		sb.append('\n');
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '#') {
					check[i][j]++;
					for (int d = 0; d < 3; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr<0 ||nr>=n || nc<0 || nc>=n) continue;
						check[nr][nc]++;
					}
				}
			}
			for(int j=0;j<n;j++) {
				if(check[i][j]%2==0) {
					map[i+1][j] = map[i][j]=='#' ? '#' : '.';
					sb.append(map[i+1][j]);
				}else {
					map[i+1][j] = map[i][j]=='#' ? '.' : '#';
					sb.append(map[i+1][j]);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}