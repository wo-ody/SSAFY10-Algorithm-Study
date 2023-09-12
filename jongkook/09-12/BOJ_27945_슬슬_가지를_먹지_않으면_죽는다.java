package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_27945_슬슬_가지를_먹지_않으면_죽는다 {
	static int vertex, edge, limit;
	static ArrayList<Node> graph;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static boolean[] visited;
	static int[] parents;
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		visited = new boolean[vertex];
		
		for(int v = 0; v < edge; v++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
//			graph.add(new Node(from, to, day));
			graph.add(new Node(from, to, day));
		}
		
		Collections.sort(graph);
		
		parents = new int[vertex+1];
		for(int i = 1; i <= vertex; i++) parents[i] = i;
		int count = 1;
		
		for(Node node : pq) {
			if(node.day != count) break;			
			if(find(node.to) != find(node.from)){
				union(node.to, node.from);
				count++;							
			}
		}
		
		System.out.println(count);

	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	
	
	
	static class Node implements Comparable<Node>{
		int from, to, day;

		public Node(int from, int to, int day) {
			super();
			this.from = from;
			this.to = to;
			this.day = day;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.day - o.day;
		}
	}
}
