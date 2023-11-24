import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {

	static int N, M, K, X;
	static int[] dist;
	static int[] ans;
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		ans = new int[N+1];
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, 1));
		}
		
		Arrays.fill(dist, INF);
		
		dijkstra(X);
		
		for (int i = 1; i < N+1; i++) {
			if(dist[i] == K) sb.append(i).append("\n");
		}
		
		if(sb.length()==0) System.out.println(-1);
		else System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost );
		pqueue.offer(new Node(start, 1));
		dist[start] = 0;
		
		while(!pqueue.isEmpty()) {
			int cur = pqueue.poll().index;
			
			if(visit[cur]) continue;
			visit[cur] = true;
			
			// 현재 정점의 리스트 다 꺼내서 거리 계산 해보기
			for (Node next : list[cur]) {
				if(dist[next.index] > dist[cur] + next.cost) {
					dist[next.index] = dist[cur] + next.cost;
					pqueue.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
	}
	
	static class Node {
		int index, cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
	
}
