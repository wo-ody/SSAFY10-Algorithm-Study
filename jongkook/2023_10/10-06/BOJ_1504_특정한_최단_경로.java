package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한_최단_경로 {
	static int vertex, edge;
	static final int INF = 200_001;
	static ArrayList<ArrayList<Node>> dList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		for(int l = 0; l <= vertex; l++) dList.add(new ArrayList<>());
		
		for(int e = 1; e <= edge; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			dList.get(from).add(new Node(to, cost));
			dList.get(to).add(new Node(from, cost));
		}
//		for(int i = 0; i <= vertex; i++) System.out.println(i + "번째" + dList.get(i));
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, vertex);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, vertex);
		
		System.out.println((res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2));
		
	}
	static int dijkstra(int start, int end) {
		int[] dist = new int[vertex+1];
		boolean[] visited = new boolean[vertex+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int num = curNode.e;
			if(visited[num]) continue;
			visited[num] = true;
			
			for(Node node : dList.get(num)) {
				if(!visited[node.e] && dist[node.e] > dist[num] + node.cost) {
					dist[node.e] = dist[num] + node.cost;
					pq.add(new Node(node.e, dist[node.e]));
				}
			}
		}
		return dist[end];
	}
	
	static class Node{
		int e, cost;

		public Node(int e, int cost) {
			super();
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", cost=" + cost + "]";
		}
	}
}
