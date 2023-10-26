package BOJ;

import java.io.*;
import java.util.*;

public class boj_1197_최소스패닝트리 {
	static int V,E;
	static ArrayList<Node> graph;
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	
		graph = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Node(a,b,c));
		}
		
		System.out.println(simulation());
		
	}
	
	static void init_parent() {
		parent = new int[V+1];
		for(int i = 1; i <= V ; i++) parent[i] = i;
	}
	
	static int find(int v) {
		if(parent[v] == v) return v;
		return parent[v] = find(parent[v]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		parent[pa] = pb;
	}
	
	static long simulation() {
		init_parent();
		Collections.sort(graph, (o1,o2) -> o1.cost - o2.cost);
		
		long result= 0;
		
		for(Node cur : graph) {
			if(find(cur.a) != find(cur.b)) {
				union(cur.a, cur.b);
				result += cur.cost;
			}
		}
		
		return result;
	}
	
	
	static class Node{
		int a,b,cost;

		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
	}

}
