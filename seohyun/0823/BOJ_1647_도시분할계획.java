import java.io.*;
import java.util.*;

//Kruskal Algorithm
public class boj_1647_도시분할계획 {
	static int N,M;
	static int[][] graph;
	static int[] parent;
	
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M][3];
		parent = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		simulation();
		System.out.println(result);
	}
	
	static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		parent[px] = py;
	}
	
	static void simulation() {
		makeSet();
		Arrays.sort(graph, (o1,o2) -> o1[2] - o2[2]);
		
		int recent_cost = 0;
		
		for (int i = 0; i < M; i++) {
			if(findSet(graph[i][0]) != findSet(graph[i][1])) {
				union(graph[i][0], graph[i][1]);
				recent_cost = graph[i][2];
				result += graph[i][2];
			}
		}
		
		result -= recent_cost;
	}

}
