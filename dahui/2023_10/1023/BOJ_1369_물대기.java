package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1368_물대기 {
	static int N,ans;
	static int[] W;
	static int[][] adjArr;
	static StringTokenizer st;
	static boolean[] visit;
	static int[] minCost;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N];
		adjArr = new int[N][N];
		visit = new boolean[N];
		minCost = new int[N];
		
		for(int i=0; i<N; i++) {
			W[i] = Integer.parseInt(br.readLine());
			
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Prim();
		
		System.out.println(ans);

	}
	
	private static void Prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		for(int i=0; i<N; i++) {
			pq.add(new Node(i, W[i]));
		}
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int node = n.node;
			int cost = n.cost;
			
			if(visit[node]) continue;
			
			visit[node] = true;
			ans += cost;
			
			for(int i=0; i<N; i++) {
				if(adjArr[node][i]!=0) {
					pq.add(new Node(i, Math.min(W[i], adjArr[node][i])));
				}
			}
			
		}
	}

	public static class Node{
		int node, cost;
		public Node (int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}

}
