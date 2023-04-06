import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<int[]>[] arrayList;
    static int N, M;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        int lt = Integer.MAX_VALUE;
        int rt = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            lt = Math.min(lt, C);
            rt = Math.max(rt, C);

            arrayList[A].add(new int[] { B, C });
            arrayList[B].add(new int[] { A, C });
        }

        st = new StringTokenizer(br.readLine());
        int depart = Integer.parseInt(st.nextToken()) - 1;
        int arrive = Integer.parseInt(st.nextToken()) - 1;

        int maxWeight = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (bfs(depart, arrive, mid)) {
                lt = mid + 1;
                maxWeight = Math.max(maxWeight, mid);
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(maxWeight);
    }

    public static boolean bfs(int cur, int dest, int w) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerLast(cur);
        visit = new boolean[N];
        visit[cur] = true;

        while (!arrayDeque.isEmpty()) {
            int a = arrayDeque.pollFirst();

            for (int i = 0; i < arrayList[a].size(); i++) {
                int[] isle = arrayList[a].get(i);
                int b = isle[0];
                int c = isle[1];

                if (c < w) {
                    continue;
                }
                if (visit[b]) {
                    continue;
                }

                if (b == dest) {
                    return true;
                }

                arrayDeque.add(b);
                visit[b] = true;
            }
        }
        return false;
    }
}
