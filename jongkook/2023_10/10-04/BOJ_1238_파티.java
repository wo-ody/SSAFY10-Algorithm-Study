package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static int vertex, edge, destination;
	static ArrayList<ArrayList<Node>> lst = new ArrayList<>();
	static ArrayList<ArrayList<Node>> returnLst = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());
		
		for(int l = 0; l <= vertex; l++) {
			lst.add(new ArrayList<>());
			returnLst.add(new ArrayList<>());
		}
	
		for(int e = 0; e < edge; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			lst.get(a).add(new Node(b, c));
			returnLst.get(b).add(new Node(a, c));

		}
		
//		for(int i = 1; i <= vertex; i++) System.out.println(i + "번 " + lst[i]);
		
//		while(!pq.isEmpty()) System.out.println(pq.poll());
		
		int[] goList = dijkstra(lst);
		int[] backList = dijkstra(returnLst);
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= vertex; i++) max = Math.max(max, goList[i] + backList[i]);
		System.out.println(max);
		
		
	}
	
	static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[vertex + 1];
		int[] dist = new int[vertex+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[destination] = 0;
		
		pq.offer(new Node(destination, 0));
		
		while(!pq.isEmpty()) {
			Node pqNode = pq.poll();
			int num = pqNode.number;
			if(visited[num]) continue; 
			visited[num] = true;
			for(Node node: list.get(num)) {
				if(!visited[node.number] && dist[node.number] > (dist[num] +node.cost)) {
					dist[node.number] = dist[num] + node.cost;
					pq.offer(new Node(node.number, dist[node.number]));
				}
			}
			
		}
		return dist;
	}
	
	static class Node implements Comparable<Node>{
		int number, cost;

		public Node(int number, int cost) {
			super();
			this.number = number;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;			
		}

	}
}
