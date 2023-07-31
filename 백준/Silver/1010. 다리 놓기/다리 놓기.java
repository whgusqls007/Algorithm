import java.util.*;
import java.io.*;

public class Main {
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      dp = new int[31][31];

      System.out.println(combi(M, N));
    }
  }

  public static int combi(int n, int r) {
    if (dp[n][r] != 0)
      return dp[n][r];
    else if (n == r || r == 0)
      return 1;
    else
      return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
  }
}