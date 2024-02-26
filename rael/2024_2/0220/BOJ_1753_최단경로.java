import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;		//정점 개수, 간선 개수, 시작 정점의 번호
	static final int INF = Integer.MAX_VALUE;
	
	static boolean visit[];
	static int dist[];
	static ArrayList<Node> graph[];
	static PriorityQueue<Node> pq;
	
	static public class Node{
		int v, c;

		public Node(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		//변수 초기화
		graph = new ArrayList[V+1];		//0 dummy
		for(int i=0; i<=V; i++) graph[i] = new ArrayList<>(); 
		
		//간선 입력 받기
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());	//시작정점
			int v = Integer.parseInt(st.nextToken());	//도착정점
			int w = Integer.parseInt(st.nextToken());	//cost
			
			graph[u].add(new Node(v, w));
		}
		
		//시작 정점으로 다익스트라
		Dijkstra(K);
		
		//출력
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
	}
	
	public static void Dijkstra(int start) {
		//변수 초기화
		visit = new boolean[V+1];		//0 dummy
		dist = new int[V+1];			//0 dummy
		Arrays.fill(dist, INF);
		
		//priority queue 선언
		pq = new PriorityQueue<Node>((e1, e2) -> e1.c-e2.c);
		
		//시작 정점에 대해 초기화
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		//pq 반복
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			//방문 체크
			if(!visit[curr.v]) visit[curr.v] = true;
			
			//현재 노드에 연결된 다음 노드들 살피기
			for(Node next : graph[curr.v]) {
				//연결된 적 없고, 바로 연결하는 것보다 현재 노드를 거쳐 가는 것이 더 작다면 업데이트
				if(!visit[next.v] && dist[next.v] > curr.c+next.c) {
					dist[next.v] = curr.c+next.c;		//최소로 업데이트
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}
