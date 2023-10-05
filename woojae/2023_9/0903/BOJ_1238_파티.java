import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, x;
	static int v1, v2, c;
	static List<List<Edge>> comback_adj;
	static List<List<Edge>> going_adj;
	static int[] cost;
	static boolean[] visit;
	static PriorityQueue<Edge> pq;
	static final int Inf = Integer.MAX_VALUE;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		makemap();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			comback_adj.get(v1).add(new Edge(v2, c));  // 기본 입력
			going_adj.get(v2).add(new Edge(v1, c));  // 입력의 반대
		}
		
		dijkstra(comback_adj, x);  // x번 기준으로 최단 경로를 찾는 것은 x에서 각 마을로 돌아가는 최단 경로와 같음
		int[] going_cost = cost.clone();
		dijkstra(going_adj, x);  //  해당 간선들 기준, 양방향 그래프라고 생각했을 때, 각 마을에서 x번 마을로 가는 것이나 x번 마을에서 각 마을로 가는 것이나 동일
		int[] comback_cost = cost.clone();
		
		for(int i = 1; i <= n; i++) {
			int sum = going_cost[i] + comback_cost[i];  // 각 마을에서 x번 마을을 왕복하는 데 소요되는 비용을 계산 후 최대값 갱신
			answer = answer < sum ? sum : answer;
		}
		System.out.println(answer);
	}
	
	static void dijkstra(List<List<Edge>> adj, int start) {
		visit = new boolean[n + 1];
		cost = new int[n + 1];
		Arrays.fill(cost, Inf);
		cost[start] = 0;
		pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.offer(new Edge(start, cost[start]));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int from = e.vertex;
			if(visit[from])  // 시작한 곳으로 다시 돌아오면 안 됨
				continue;
			visit[from] = true;
			for (Edge to : adj.get(from)) {
				if(cost[from] + to.cost < cost[to.vertex]) {
					cost[to.vertex] = cost[from] + to.cost;
					pq.offer(new Edge(to.vertex, cost[to.vertex]));
				}
			}
		}
	}
	
	static void makemap() {
		comback_adj = new ArrayList<List<Edge>>();
		going_adj = new ArrayList<List<Edge>>();
		for(int i = 0; i <= n; i++) {
			comback_adj.add(new ArrayList<Edge>());
			going_adj.add(new ArrayList<Edge>());
		}
	}
	
	static class Edge {
		int vertex, cost;
		Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}
}