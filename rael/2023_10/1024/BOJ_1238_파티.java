import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;		//정점 개수, 간선 개수, 도착점(이자 시작점)
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node> graph[];
	static int[] dist;
	
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		//변수 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		
		//그래프 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[v1].add(new Node(v2, c));
		}
		
		//다익스트라(각자의 집->X)
		int cost[] = new int[N+1];	//0 dummy
		for(int i=1; i<=N; i++) {
			cost[i] = Dijkstra(i,X);
		}
		//다익스트라(X->각자의 집)
		DijkstraX(X);
		
		//거리 계산
		int max = 0;
		for(int i=1; i<=N; i++) {
			cost[i] += dist[i];
			max = Math.max(max, cost[i]);
		}
		
		System.out.println(max);
	}
	static public int Dijkstra(int start, int end){
		//변수 초기화
		int[] d = new int[N+1];
		Arrays.fill(d, INF);
		
		//pq 선언
		PriorityQueue<Node> pq = new PriorityQueue<Node>((e1,e2)->e1.c-e2.c);
		
		//시작점 기반 초기화
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		//pq 내부 반복
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			//최소 체크
			if(d[curr.v] < curr.c) continue;		//더이상 최소를 구할 수 없으므로
			
			//다음 노드 연결
			for(Node next : graph[curr.v]) {
				if(d[next.v] > curr.c+next.c) {
					d[next.v] = curr.c+next.c;
					pq.add(new Node(next.v, d[next.v]));
				}
			}
		}
		
		return d[end];
	}
	
	static public void DijkstraX(int start){
		//변수 초기화
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		//pq 선언
		PriorityQueue<Node> pq = new PriorityQueue<Node>((e1,e2)->e1.c-e2.c);
		
		//시작점 기반 초기화
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		//pq 내부 반복
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			//최소 체크
			if(dist[curr.v] < curr.c) continue;		//더이상 최소를 구할 수 없으므로
			
			//다음 노드 연결
			for(Node next : graph[curr.v]) {
				if(dist[next.v] > curr.c+next.c) {
					dist[next.v] = curr.c+next.c;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}
