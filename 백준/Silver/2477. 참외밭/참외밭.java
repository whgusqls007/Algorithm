import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 6;
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int sum = 0;
        int horMax = 0;
        int verMax = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (d == 1 || d == 2) {
                verMax = Math.max(verMax, l);
            } else {
                horMax = Math.max(horMax, l);
            }
            arr[i] = l;
        }

        for (int i = 0; i < N; i++) {
            sum += arr[i] * arr[(i + 1) % N];
        }

        System.out.println((sum - ((verMax * horMax) * 2)) * K);
    }
}
