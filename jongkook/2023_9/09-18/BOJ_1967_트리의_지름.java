package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {
	static ArrayList<Node> tree[];
	static boolean[] visited;
	static int MAX_VERTEX = Integer.MIN_VALUE, MAX = Integer.MIN_VALUE;
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		tree = new ArrayList[size + 1];
		visited = new boolean[size+1];
		
		for(int i = 1; i <= size; i++) tree[i] = new ArrayList<Node>();
		
		for(int i = 1; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			tree[from].add(new Node(to, len));
			tree[to].add(new Node(from, len));
		}
		
		dfs(1,0);
		Arrays.fill(visited, false);
		
		dfs(MAX_VERTEX, 0);
		
		System.out.println(MAX);
	}
	
	static void dfs(int start, int depth) {
		for(Node node : tree[start]) {
			if(!visited[node.vertex]) {
				visited[node.vertex] = true;
				dfs(node.vertex, depth + node.edge);
			}
		}
		if(MAX < depth) {
			MAX = depth;
			MAX_VERTEX = start;
		}
	}
	static class Node{
		int vertex, edge;

		public Node(int vertex, int edge) {
			super();
			this.vertex = vertex;
			this.edge = edge;
		}
	}	
}
