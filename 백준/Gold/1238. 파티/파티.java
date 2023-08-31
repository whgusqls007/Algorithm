import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    List<int[]>[] list = new ArrayList[N + 1];
    for (int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      list[Integer.parseInt(st.nextToken())]
          .add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
    }

    final int INF = 100_000_000;
    int[] arr = new int[N + 1];
    int res = -1;
    for (int i = 1; i < N + 1; i++) {
      Arrays.fill(arr, INF);
      arr[i] = 0;
      djik(i, arr, list);
      int dist1 = arr[X];
      Arrays.fill(arr, INF);
      arr[X] = 0;
      djik(X, arr, list);
      int dist2 = arr[i];

      res = Math.max(res, dist1 + dist2);
    }

    System.out.println(res);
  }

  public static void djik(int depart, int[] arr, List<int[]>[] list) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
    pq.offer(new int[] { depart, 0 });

    while (!pq.isEmpty()) {
      int cur = pq.peek()[0];
      int curCost = pq.poll()[1];

      if (curCost > arr[cur]) {
        continue;
      }

      for (int[] tmp : list[cur]) {
        int next = tmp[0];
        int nextCost = tmp[1];

        if (arr[next] > curCost + nextCost) {
          arr[next] = curCost + nextCost;
          pq.offer(new int[] { next, curCost + nextCost });
        }
      }
    }
  }
}
