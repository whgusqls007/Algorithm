import java.io.*;
import java.util.*;

public class Main {

  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      if (M == 0 && N == 0) {
        bw.flush();
        break;
      }

      int total = 0;

      arr = new int[M];
      for (int i = 0; i < M; i++) {
        arr[i] = i;
      }

      int[][] edges = new int[N][3];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        edges[i][0] = x;
        edges[i][1] = y;
        edges[i][2] = z;
        total += z;
      }

      Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));

      int light = 0;
      for (int i = 0; i < N; i++) {
        int node1 = edges[i][0];
        int node2 = edges[i][1];

        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
          union(node1, node2);
          light += edges[i][2];
        }
      }

      bw.write((total - light) + "\n");
    }
  }

  public static void union(int a, int b) {
    if (a <= b) {
      arr[b] = a;
    } else {
      arr[a] = b;
    }
  }

  public static int find(int a) {
    if (arr[a] == a) {
      return a;
    }
    return arr[a] = find(arr[a]);
  }
}
