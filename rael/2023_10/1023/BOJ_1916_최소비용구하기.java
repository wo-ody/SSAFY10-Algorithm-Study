import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, start, end;		//도시 수(정점), 버스 수(간선), 시작점, 도착점
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
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		//변수 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		
		//입력 받기
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[v1].add(new Node(v2, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		//다익스트라
		Dijkstra(start);
		
		//출력(도착점 고려할 것!)
		System.out.println(dist[end]);
	}
	
	static public void Dijkstra(int start) {
		//변수 초기화
		visit = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		//PQ 초기화
		pq = new PriorityQueue<Node>((e1, e2) -> e1.c-e2.c);
		
		//시작 정점에 대해 초기화
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		//큐에 담긴 정점에 대해
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			//방문 체크
			if(!visit[curr.v]) visit[curr.v] = true;
			
			//
			if(dist[curr.v] < curr.c) continue;
			
			//다음 노드 방문
			for(Node next : graph[curr.v]) {
				//방문한 적 없고, 현재 노드를 거쳐 가는 루트가 더 최소라면 업데이트
				if(!visit[next.v] && dist[next.v] > curr.c+next.c) {
					dist[next.v] = curr.c+next.c;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
	
}
