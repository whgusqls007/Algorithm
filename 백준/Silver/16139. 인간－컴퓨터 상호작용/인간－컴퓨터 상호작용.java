import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String S = br.readLine();
    int[][] arr = new int[26][S.length() + 1];

    for (int i = 1; i < S.length() + 1; i++) {
      arr[S.charAt(i - 1) - 97][i]++;

      for (int j = 0; j < 26; j++) {
        arr[j][i] += arr[j][i - 1];
      }
    }

    int q = Integer.parseInt(br.readLine());

    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int c = st.nextToken().toCharArray()[0] - 97;
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      bw.write(arr[c][e + 1] - arr[c][s] + "\n");
    }

    bw.flush();
  }
}
