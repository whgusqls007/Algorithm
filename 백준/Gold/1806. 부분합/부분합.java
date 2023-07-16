import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] sum = new int[N + 1];
    for (int i = 1; i < N + 1; i++) { // O(N)
      sum[i] = sum[i - 1] + arr[i - 1];
    }

    // 이분탐색
    int left = 0;
    int right = N;
    int min = Integer.MAX_VALUE;

    continuePoint: while (left <= right) {
      int mid = (left + right) / 2; // 길이

      for (int i = 0; i < N - mid + 1; i++) {
        if (sum[i + mid] - sum[i] >= S) {
          min = Math.min(min, mid);
          right = mid - 1;
          continue continuePoint;
        }
      }

      left = mid + 1;
    }

    System.out.println(min == Integer.MAX_VALUE ? 0 : min);
  }
}