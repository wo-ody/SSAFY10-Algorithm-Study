package algorithm2023.dec.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static ArrayList<Edge> edge = new ArrayList<>();
	
	static int[] parent;
	
	
	static class Edge{
		int from,to,cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}
	
	static void init(int n) {
		parent = new int[n+1];
		for(int i =0 ;i<=n;i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py)return false;
		
		parent[px] = py;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		//정점의 수 N, 간선의 수 M
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge.add(new Edge(from, to, cost));
		}
		
		System.out.println(kruskal());
		
	}
	
	
	static int kruskal() {
		init(N);
		Collections.sort(edge, (o1,o2)->o1.cost-o2.cost);
		int sum = 0;
		for(Edge e : edge) {
			if(union(e.to, e.from)) {
				sum+=e.cost;
			}
		}
		return sum;
	}
}	
