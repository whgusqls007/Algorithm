import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = i;
    }

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (union(arr, a, b)) {
        System.out.println(m + 1);
        System.exit(0);
      }
    }
    System.out.println(0);
  }

  public static boolean union(int[] arr, int a, int b) {
    a = find(arr, a);
    b = find(arr, b);

    if (a == b) {
      return true;
    } else if (a < b) {
      arr[b] = a;
    } else {
      arr[a] = b;
    }

    return false;
  }

  public static int find(int[] arr, int a) {
    if (arr[a] == a) {
      return a;
    }
    return arr[a] = find(arr, arr[a]);
  }
}