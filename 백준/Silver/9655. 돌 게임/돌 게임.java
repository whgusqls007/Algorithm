import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();
    if ((N & 1) == 1) {
      System.out.println("SK");
    } else {
      System.out.println("CY");
    }
  }
}