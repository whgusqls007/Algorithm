import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int                        V, E, K;
	static ArrayList<ArrayList<Edge>> vertex = new ArrayList<ArrayList<Edge>>();
	static boolean[]                  visit;
	static int[]                      cost;
	static PriorityQueue<Edge>        pq     = new PriorityQueue<Edge>(
			(e1, e2) -> Integer.compare(e1.c, e2.c)
	);
	static final int                  INF    = Integer.MAX_VALUE;

	static class Edge {
		int v, c;

		public Edge(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V     = Integer.parseInt(st.nextToken());
		E     = Integer.parseInt(st.nextToken());
		K     = Integer.parseInt(br.readLine());

		visit = new boolean[V + 1];
		cost  = new int[V + 1];                  // prim에는 없는 놈임

		for (int i = 0; i < V + 1; i++) {
			vertex.add(new ArrayList<Edge>());
			cost[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c  = Integer.parseInt(st.nextToken());
			// v1에서 갈수 있는 v2와 그 cost
			vertex.get(v1).add(new Edge(v2, c));
		}
		dijkstra();

		for (int i = 1; i <= V; i++) {
			bw.write(cost[i] == INF ? "INF\n" : String.format("%d\n", cost[i]));
		}
		bw.flush();
	}

	static void dijkstra() {
		// 시작은 K --> 자기 자신한테 가는건 0임
		cost[K] = 0;
		pq.offer(new Edge(K, 0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visit[edge.v]) continue;
			visit[edge.v] = true;

			// pq 에서 꺼낸놈들로 부터 갈수 있는 다음 노드들
			for (Edge next : vertex.get(edge.v)) {

				if (!visit[next.v] && cost[next.v] > cost[edge.v] + next.c) {
					cost[next.v] = cost[edge.v] + next.c;
					pq.offer(new Edge(next.v, cost[next.v]));
				}
			}
		}
	}
}