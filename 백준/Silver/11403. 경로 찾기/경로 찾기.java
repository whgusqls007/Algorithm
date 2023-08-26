import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int INF = 1_000_000_000;
    int[][] arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 0) {
          arr[i][j] = INF;
        } else {
          arr[i][j] = tmp;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {

        for (int k = 0; k < N; k++) {
          if (arr[j][i] == INF || arr[i][k] == INF)
            continue;

          arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == INF) {
          bw.write("0 ");
        } else {
          bw.write("1 ");
        }
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
