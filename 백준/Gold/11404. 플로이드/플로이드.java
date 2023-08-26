import java.util.*;
import java.io.*;

public class Main {
  static int INF = 100_000_000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[][] arr = new int[N + 1][N + 1];
    for (int i = 0; i < arr.length; i++) {
      Arrays.fill(arr[i], INF);
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      arr[a][b] = Math.min(arr[a][b], c);
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        if (i == j) {
          continue;
        }

        for (int k = 1; k < N + 1; k++) {
          if (j == k || arr[j][i] == INF || arr[i][k] == INF) {
            continue;
          }

          arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        bw.write(arr[i][j] == INF ? 0 + " " : arr[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
