import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] coord = new int[N + 1][2];
    for (int i = 1; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine());
      coord[i][0] = Integer.parseInt(st.nextToken());
      coord[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] arr = new int[N + 1];
    boolean[] con = new boolean[N + 1];
    for (int i = 0; i < N + 1; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      con[x] = true;
      con[y] = true;
      union(x, y, arr);
    }

    ArrayList<Object[]> list = new ArrayList<>();
    for (int i = 1; i < N + 1; i++) {
      int x1 = coord[i][0];
      int y1 = coord[i][1];

      for (int j = i + 1; j < N + 1; j++) {
        int x2 = coord[j][0];
        int y2 = coord[j][1];

        double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        list.add(new Object[] { dist, i, j });
      }
    }

    Collections.sort(list, (e1, e2) -> Double.compare((double) e1[0], (double) e2[0]));
    double answer = 0;
    for (int i = 0; i < list.size(); i++) {
      double dist = (double) list.get(i)[0];
      int n1 = (int) list.get(i)[1];
      int n2 = (int) list.get(i)[2];

      if (!union(n1, n2, arr)) {
        answer += dist;
      }
    }

    System.out.println(String.format("%.2f", answer));
  }

  public static boolean union(int x, int y, int[] arr) {
    x = find(x, arr);
    y = find(y, arr);

    if (x == y)
      return true;
    else if (x > y) {
      arr[y] = x;
    } else {
      arr[x] = y;
    }

    return false;
  }

  public static int find(int x, int[] arr) {
    if (arr[x] == x) {
      return x;
    }
    return arr[x] = find(arr[x], arr);
  }
}
