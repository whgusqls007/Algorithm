import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    List<List<int[]>> list = new ArrayList<>();
    for (int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
    }

    StringTokenizer st = null;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      list.get(Integer.parseInt(st.nextToken()))
          .add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
    }

    st = new StringTokenizer(br.readLine());
    int depart = Integer.parseInt(st.nextToken());
    int arrive = Integer.parseInt(st.nextToken());

    br.close();

    int INF = 1_000_000_000;
    int[] arr = new int[N + 1];
    int[] route = new int[N + 1];

    Arrays.fill(arr, INF);

    PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
    pq.offer(new int[] { depart, 0 });
    arr[depart] = 0;

    while (!pq.isEmpty()) {

      int[] tmp = pq.poll();
      int curNode = tmp[0];
      int curCost = tmp[1];

      if (arr[curNode] < curCost) {
        continue;
      }

      for (int[] next : list.get(curNode)) {
        int nextNode = next[0];
        int nextCost = next[1];

        if (arr[nextNode] > curCost + nextCost) {
          arr[nextNode] = curCost + nextCost;
          route[nextNode] = curNode;
          pq.offer(new int[] { nextNode, curCost + nextCost });
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append(arr[arrive]).append("\n");

    List<Integer> answer = new ArrayList<>();
    for (int i = arrive; i != 0; i = route[i]) {
      answer.add(i);
    }

    sb.append(answer.size()).append("\n");
    for (int i = answer.size() - 1; i > -1; i--) {
      sb.append(answer.get(i)).append(" ");
    }

    System.out.println(sb);
  }
}
