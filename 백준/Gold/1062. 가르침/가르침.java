import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 5;

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        if (K < 0) {
            System.out.println(0);
            System.exit(0);
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (char chr : words[i].toCharArray()) {
                set.add(chr);
            }
        }

        Object[] keySet = set.toArray();
        int size = keySet.length;

        if (size == 0) {
            System.out.println(N);
            System.exit(0);
        }

        int max = -1;

        while (np(size, K)) {
            int cnt = 0;
            set.clear();

            for (int i = 0; i < size; i++) {
                if (arr[i] == 1) {
                    set.add((char) keySet[i]);
                }
            }

            continuePoint: for (int i = 0; i < N; i++) {
                for (char chr : words[i].toCharArray()) {
                    if (!set.contains(chr)) {
                        continue continuePoint;
                    }
                }
                cnt++;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    public static boolean np(int size, int cnt) {
        if (arr == null) {
            arr = new int[size];
            if (size < cnt) {
                Arrays.fill(arr, 1);
            } else {
                for (int i = size - cnt; i < size; i++) {
                    arr[i] = 1;
                }
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
            swap(i++, k--);
        }

        return true;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
