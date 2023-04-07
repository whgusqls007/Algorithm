import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static ArrayList<int[]> al;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        al = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            al.add(new int[] { a, b, c });
        }

        Collections.sort(al, (e1, e2) -> e1[2] - e2[2]);
        int cost = 0;
        for (int i = 0; i < M; i++) {
            int[] pair = al.get(i);
            if (find(pair[0]) != find(pair[1])) {
                union(pair[0], pair[1]);
                cost += pair[2];
            }
        }
        System.out.println(cost);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            arr[y] = x;
        } else {
            arr[x] = y;
        }
    }

    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }
}
