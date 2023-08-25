import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N + 1];
    int cnt = M;

    for (int i = 0; i < N + 1; i++) {
      arr[i] = i;
    }

    st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int min = 0;
    if (a == 0) {
      System.out.println(M);
      System.exit(0);
    } else if (a >= 1) {
      for (int i = 0; i < a; i++) {
        int b = Integer.parseInt(st.nextToken());
        arr[b] = 0;
      }
    }

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens()) {
        list.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }

    for (int i = 0; i < M; i++) {
      int n = list.get(i).get(0);
      for (int j = 1; j < n; j++) {
        union(arr, list.get(i).get(j), list.get(i).get(j + 1));
      }
    }

    continuePoint: for (int i = 0; i < M; i++) {
      int n = list.get(i).get(0);
      for (int j = 1; j < n + 1; j++) {
        if (find(arr, list.get(i).get(j)) == 0) {
          cnt--;
          continue continuePoint;
        }
      }
    }

    System.out.println(cnt);
  }

  public static void union(int[] arr, int a, int b) {
    a = find(arr, a);
    b = find(arr, b);

    if (a <= b) {
      arr[b] = a;
    } else {
      arr[a] = b;
    }
  }

  public static int find(int[] arr, int a) {
    if (arr[a] == a) {
      return a;
    }
    return arr[a] = find(arr, arr[a]);
  }
}
