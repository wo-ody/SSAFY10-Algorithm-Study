package kruskal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용_구하기 {
	static boolean[] visited;
	static int[] dist;
	static int node, edge;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] graph;
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[node+1];
		
		for(int i = 0; i <= node; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[v].add(new Node(e,w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
//		for(int i : dist) {
//			if(i == INF) System.out.println(0 + " ");
//			else System.out.println(i + " ");
//		}
		System.out.println(dist[destination]);
		
	}
	
	static void dijkstra(int start) {
		// 0번째 인덱스는 사용하지 않는다.
		visited = new boolean[node+1];
		dist = new int[node+1];
		Arrays.fill(dist, INF);
		// dist 에는 현재 노드까지의 무한대의 값이 저장되어있음
		// 최소값과 비교했을 때 교환이 되어야하기 때문에?
		dist[start] = 0;
		
		// dijkstra 알고리즘 구현을 위해 우선순위 큐를 사용한다.
		// 가중치가 적은 간선을 먼저 계산하기 위해서 사용됨
		// 효율적인 알고리즘이란가 뭐란가 암튼 그거임
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 시작점의 노드는 가중치가 0임
		pq.offer(new Node(start, 0));
		
		// BFS 랑 비슷하게 생긴듯
		while(!pq.isEmpty()) {
			// Node 클래스의 첫 번째 원소는 노드, 두 번째 원소는 가중치임 
			// 여기서 index는 현재 원소를 의미
			int nowVoltex = pq.poll().index;
			if(visited[nowVoltex]) continue;
			visited[nowVoltex] = true;
			
			// 이제 인덱스와 연결된 애들 비교해야됌
			for(Node nextNode : graph[nowVoltex]) {
				// 현재 노드의 가중치와 다음 노드의 가중치를 합치면 현재 위치에서 다음 노드로 가는데의 값을 구할 수 있다
				// 이때 다음 노드의 값과 현재 노드의 값과 다음 노드의 가중치를 더한 값을 비교 했을 때 더 작은 값이 다음 노드를 대체한다.
				if(dist[nextNode.index] > dist[nowVoltex] + nextNode.cost ) {
					dist[nextNode.index] = dist[nowVoltex] + nextNode.cost;
					pq.offer(new Node(nextNode.index, dist[nextNode.index]));
				}
				
			}		
			
		}
	}
	
}



class Node implements Comparable<Node>{
	int index;
	int cost;
	
	public Node(int index, int cost) {
		super();
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.cost, node.cost);
	}
	
}
