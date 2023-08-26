import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    Map<Integer, Integer> map = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      map.put(i, Integer.parseInt(st.nextToken()));
    }

    int[][] arr = new int[N + 1][N + 1];
    final int INF = 100_000_000;

    for (int i = 0; i < N + 1; i++) {
      Arrays.fill(arr[i], INF);
    }

    for (int i = 1; i < N + 1; i++) {
      arr[i][i] = 0;
    }

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());
      arr[a][b] = l;
      arr[b][a] = l;
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        if (i == j) {
          continue;
        }
        for (int k = 1; k < N + 1; k++) {
          if (i == k || j == k || arr[j][i] == INF || arr[i][k] == INF) {
            continue;
          }

          arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        }
      }
    }
    int max = -1;
    for (int i = 1; i < N + 1; i++) {
      int sum = 0;
      for (int j = 1; j < N + 1; j++) {
        if (arr[i][j] <= M) {
          sum += map.get(j);
        }
      }
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
