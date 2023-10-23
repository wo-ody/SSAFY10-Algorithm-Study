import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static List<List<Edge>> adjList = new ArrayList<>();
	static int[] cost;		//다익스트라 자료구조 <= 이 곳에 답이 정리됨.
	static boolean[] visit;
	//최소비용 간선 선택
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->e1.c-e2.c); 
	static StringBuilder sb = new StringBuilder();
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		cost = new int[V+1];
		visit = new boolean[V+1];
		
		//인접리스트 초기화
		for(int i=0; i<=V; i++) {
			adjList.add(new ArrayList<Edge>());
			cost[i] = INF;		//충분히 큰 값(무한대)
		}
		
		//간선
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//v1 -> v2
			adjList.get(v1).add(new Edge(v2, w));
		}
		
		//다익스트라 풀이
		dijkstra();
		
		//출력
		for(int i=1; i<=V; i++) {
			sb.append(cost[i] == INF ? "INF" : cost[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		//시작 정점
		cost[K] = 0;
		
		pq.offer(new Edge(K, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();		//최소 비용의 간선
			if(visit[e.v]) continue;
			
			visit[e.v] = true;		//방문 안 했으면, 방문처리
			
			//꺼낸 간선이 갈 수 있는 정점 고려 => 이 정점에서 갈 수 있는 다른 정점과의 비용으로 cost[] 갱신
			for(Edge ne : adjList.get(e.v)) {
				//아직 방문하지 않은 정점이면서, 동시에 cost[] 비용을 줄여줄 수 있는 정점이라면
				//(꺼낸 e.v -> ne.v 비용 + cost[e.v] 비교)
				if(ne.c + cost[e.v] < cost[ne.v]) {
					cost[ne.v] = ne.c + cost[e.v];
//					pq.offer(new Edge(ne.v, cost [ne.v]));		//Edge 객체를 새로 생성
					
					ne.c = cost[ne.v];
					pq.offer(ne);
				}
			}
			
		}
	}
	
	static class Edge {
		int v, c;
		
		Edge(int v, int c){
			this.v = v;
			this.c = c;
		}
	}
}