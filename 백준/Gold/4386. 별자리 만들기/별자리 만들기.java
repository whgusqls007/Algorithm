import java.util.*;
import java.io.*;

class Star {
    int n;
    double x;
    double y;

    public Star(int n, double x, double y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }
}

class Edge {
    int s1;
    int s2;
    double dist;

    public Edge(int s1, int s2, double dist) {
        this.s1 = s1;
        this.s2 = s2;
        this.dist = dist;
    }
}

public class Main {
    static int N;
    static int[] arr;
    static ArrayList<Star> stars;
    static ArrayList<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        stars = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            stars.add(new Star(i, a, b));
        }

        edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Star star1 = stars.get(i);
                Star star2 = stars.get(j);
                double dist = Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges, (e1, e2) -> Double.compare(e1.dist, e2.dist));

        double cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (find(edge.s1) != find(edge.s2)) {
                union(edge.s1, edge.s2);
                cost += edge.dist;
            }
        }

        System.out.println(String.format("%.2f", cost));
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
