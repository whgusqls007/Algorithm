import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = null;
    static int N, M;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    house.add(new int[] { i, j });
                } else if (tmp == 2) {
                    chicken.add(new int[] { i, j });
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        while (np()) {
            int distance = getMinDistance();
            minDistance = Math.min(minDistance, distance);
        }

        System.out.println(minDistance);
    }

    public static int getMinDistance() {
        int sum = 0;
        continuePoint: for (int i = 0; i < house.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) {
                if (arr[j] == 0)
                    continue;

                int[] h = house.get(i);
                int[] c = chicken.get(j);

                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);

                minDist = Math.min(minDist, dist);

                if (minDist == 1) {
                    sum += 1;
                    continue continuePoint;
                }
            }

            sum += minDist;
        }

        return sum;
    }

    public static boolean np() {
        int size = chicken.size();

        if (arr == null) {
            arr = new int[size];
            for (int i = size - 1; i > size - M - 1; i--) {
                arr[i] = 1;
            }
            return true;
        }

        int i = size - 1;
        while (i > 0 && arr[i] <= arr[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = size - 1;

        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        int k = size - 1;

        while (i < k) {
            swap(i, k);
            i++;
            k--;
        }
        return true;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
