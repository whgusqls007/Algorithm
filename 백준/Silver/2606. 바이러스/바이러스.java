import java.io.*;
import java.util.*;

public class Main {
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    // 1. 배열만들기
    arr = new int[N + 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }

    // 3. Union (합치기)
    for (int i = 0; i < M; i++) {
      String[] str = br.readLine().split(" ");
      int com1 = Integer.parseInt(str[0]);
      int com2 = Integer.parseInt(str[1]);
      union(com1, com2);
    }

    // 4. Find (찾기)
    int cnt = 0;
    for (int i = 1; i < N + 1; i++) {
      if (find(i) == 1) {
        cnt++;
      }
    }
    System.out.println(cnt - 1);
  }

  // 2. Union, Find 함수 만들기
  /*
   * 두 노드들을 합치는 함수
   */
  public static void union(int com1, int com2) {
    int a = find(com1);
    int b = find(com2);

    if (a <= b) {
      arr[b] = a;
    } else {
      arr[a] = b;
    }

    return;
  }

  /*
   * 해당 노드의 부모를 찾는 함수(재귀)
   */
  public static int find(int com) {
    if (arr[com] == com) {
      return com;
    }

    return arr[com] = find(arr[com]);

    // int parents = find(arr[com]);
    // arr[com] = parents;
    // return parents;
  }
}