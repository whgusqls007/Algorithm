import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) + 1000000;
        }

        int[] count = new int[2000001];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < 2000001; i++) {
            count[i] += count[i - 1];
        }

        for (int i = N - 1; i > -1; i--) {
            result[--count[arr[i]]] = arr[i] - 1000000;
        }

        for (int i = 0; i < N; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
    }
}
