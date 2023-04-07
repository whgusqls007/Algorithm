import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<int[]> al;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        al = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            al.add(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) });
        }

        Collections.sort(al, (e1, e2) -> e1[2] - e2[2]);
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        int cost = 0;
        int maxCost = 0;
        for (int i = 0; i < M; i++) {
            int[] node = al.get(i);
            int n1 = node[0];
            int n2 = node[1];
            int c = node[2];
            if (find(n1) != find(n2)) {
                union(n1, n2);
                cost += c;
                maxCost = Math.max(maxCost, c);
            }
        }
        System.out.println(cost - maxCost);

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
