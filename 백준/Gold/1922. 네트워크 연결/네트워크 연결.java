import java.io.*;
import java.util.*;

public class Main {

  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int answer = 0;

    arr = new int[N + 1];
    for (int i = 0; i < N + 1; i++) {
      arr[i] = i;
    }

    int[][] edges = new int[M][3];

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      edges[i][0] = Integer.parseInt(st.nextToken());
      edges[i][1] = Integer.parseInt(st.nextToken());
      edges[i][2] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));

    // for (int i = 0; i < M; i++) {
    // System.out.println(Arrays.toString(edges[i]));
    // }

    for (int i = 0; i < M; i++) {
      int node1 = edges[i][0];
      int node2 = edges[i][1];

      node1 = find(node1);
      node2 = find(node2);
      if (node1 != node2) {
        union(node1, node2);
        answer += edges[i][2];
      }
    }

    System.out.println(answer);
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
