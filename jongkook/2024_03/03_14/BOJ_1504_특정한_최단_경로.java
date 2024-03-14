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
	static final int INF = Integer.MAX_VALUE;
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

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		long res1 = 0;

		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, vertex);

		long res2 = 0;
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
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int num = curNode.e;
			if(visited[num]) continue;
			visited[num] = true;

			// 현재 정점에서 갈수있는 다른 정점
			for(Node node : dList.get(num)) {
				// 다음 노드의 갈 수 있는 길이와 현재 정점까지의 거리와 다음 노드의 길이를 더해서
				// 다음 노드의 길이와 비교해서 작은값으로 갱신
				if(!visited[node.e] && dist[node.e] > dist[num] + node.cost) {
					dist[node.e] = dist[num] + node.cost;
					pq.add(new Node(node.e, dist[node.e]));
				}
			}
		}
		return dist[end];
	}
	
	static class Node implements Comparable<Node>{
		int e, cost;

		public Node(int e, int cost) {
			super();
			this.e = e;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
}
