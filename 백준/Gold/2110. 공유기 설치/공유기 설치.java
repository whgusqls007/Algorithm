import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N - 1];
        int maxDist = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = check(arr, mid, N);

            if (count < C) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                maxDist = Math.max(maxDist, mid);
            }
        }

        System.out.println(maxDist);
    }

    public static int check(int[] arr, int dist, int N) {
        int rv = 1;

        int point = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] - point >= dist) {
                rv++;
                point = arr[i];
            }
        }

        return rv;
    }
}
