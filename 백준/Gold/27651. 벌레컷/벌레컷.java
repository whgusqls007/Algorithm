import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[] sum = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        long cnt = 0;
        for (int stomach = 2; stomach < N; stomach++) {
            int lt = 0;
            int rt = stomach - 1;
            int headPoint = -1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                long headSize = sum[mid];
                long chestSize = sum[stomach - 1] - headSize;
                long stomachSize = sum[N - 1] - chestSize - headSize;

                if (headSize == 0 || chestSize == 0) {
                    break;
                }

                if (isPossible(headSize, chestSize, stomachSize)) {
                    lt = mid + 1;
                    headPoint = mid;
                } else {
                    rt = mid - 1;
                }
            }
            if (headPoint != -1) {
                cnt += (long) headPoint + 1;
            }

        }

        System.out.println(cnt);
    }

    public static boolean isPossible(long a, long b, long c) {
        if (b > c && c > a) {
            return true;
        } else {
            return false;
        }
    }
}
