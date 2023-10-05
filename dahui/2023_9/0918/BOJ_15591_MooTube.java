import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N,Q,cnt;
	static boolean[] visit;
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<ArrayList<Node>>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
	
		visit = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			adjList.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adjList.get(p).add(new Node(q,r));
			adjList.get(q).add(new Node(p,r));
		}
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			cnt = 0;
			bfs(k, v);
			
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int k, int v) {
		visit = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(v);
		visit[v] = true;
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int i=0; i<adjList.get(a).size(); i++) {
				int node = adjList.get(a).get(i).node;
				int usado = adjList.get(a).get(i).usado;
				if(usado >= k && !visit[node]) {
					q.add(node);
					visit[node] = true;
					cnt++;
				}

			}
		}
		return;
	}
	
	public static class Node{
		int node;
		int usado;
		public Node(int node, int usado) {
			this.node = node;
			this.usado = usado;
		}
	}
}
