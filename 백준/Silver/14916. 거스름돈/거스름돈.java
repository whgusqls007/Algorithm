import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();
    int dp[] = new int[100001];

    dp[0] = Integer.MAX_VALUE;
    dp[1] = Integer.MAX_VALUE;
    dp[2] = 1;
    dp[3] = Integer.MAX_VALUE;
    dp[4] = 2;
    dp[5] = 1;


    for (int i = 6; i <= N; i++) {
      dp[i] = Math.min(dp[i - 5], dp[i - 2]) + 1;
    }
    System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);

    /*
     * 0 1 2 3 4 5 6 7 8 9 10
     * -1 -1 1 -1 2 1 3 2 4 3 2
     */
  }
}
