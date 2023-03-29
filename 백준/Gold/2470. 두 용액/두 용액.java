import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int l1 = arr[0];
        int l2 = arr[1];
        int sum = arr[0] + arr[1];

        breakPoint: for (int i = 0; i < N; i++) {
            int pick = arr[i];
            if (i == 0) {
                arr[i] = arr[i + 1];
            } else {
                arr[i] = arr[i - 1];
            }

            int lt = 0;
            int rt = N - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;

                if (Math.abs(sum) > Math.abs(pick + arr[mid])) {
                    sum = pick + arr[mid];
                    l1 = pick;
                    l2 = arr[mid];
                }

                if (pick + arr[mid] < 0) {
                    lt = mid + 1;
                } else if (pick + arr[mid] > 0) {
                    rt = mid - 1;
                } else {
                    l1 = pick;
                    l2 = arr[mid];
                    break breakPoint;
                }
            }

            arr[i] = pick;
        }

        System.out.println(l1 + " " + l2);
    }
}
