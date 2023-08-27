import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static List<List<int[]>> list;
  static final int INF = 1_000_000_000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int depart = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    for (int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int city1 = Integer.parseInt(st.nextToken());
      int city2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      list.get(city1).add(new int[] { city2, cost });
    }

    int[] arr = dijkstra(depart);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 1; i < arr.length; i++) {
      bw.write(arr[i] == INF ? "INF\n" : arr[i] + "\n");
    }
    bw.flush();
  }

  public static int[] dijkstra(int depart) {
    // 비용 배열 초기화
    int[] arr = new int[N + 1];
    Arrays.fill(arr, INF);
    arr[depart] = 0;

    // 우선순위 큐 생성
    PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
    pq.offer(new int[] { depart, 0 });

    // 다익스트라
    while (!pq.isEmpty()) {
      int[] tmp = pq.poll();
      int city = tmp[0];
      int cost = tmp[1];

      if (cost > arr[city])
        continue;

      for (int i = 0; i < list.get(city).size(); i++) {
        int[] tmp2 = list.get(city).get(i);
        int nextCity = tmp2[0];
        int nextCost = tmp2[1];

        if (arr[nextCity] > cost + nextCost) {
          arr[nextCity] = cost + nextCost;
          pq.offer(new int[] { nextCity, cost + nextCost });
        }
      }
    }

    return arr;
  }
}
