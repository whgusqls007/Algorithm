import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      System.out.println(str.matches("^[ABCDEF]?A+F+C+[ABCDEF]?$") ? "Infected!" : "Good");
    }
  }
}