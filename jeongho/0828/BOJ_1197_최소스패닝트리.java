package algorithm2023.aug.day28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	static int V, E;

	static int[] parent;
	
	static ArrayList<Edge> edge = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		init(V);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge.add(new Edge(a,b,c));
		}
		
		Collections.sort(edge, (o1,o2)->o1.cost-o2.cost);
		
		int sum = 0;
		int cnt = 0;
		for(int i= 0;i<E;i++) {
			Edge cur = edge.get(i);
			if(union(cur.a,cur.b)) {
				sum+=cur.cost;
				cnt++;
				if(cnt==V-1)break;
			}
		}
		System.out.println(sum);
		
	}
	static void init(int n) {
		parent = new int[n+1];
		for(int i= 0;i<=n;i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py)return false;
		
		parent[px] = py;
		return true;
	}
	

	static class Edge {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

	}
}
