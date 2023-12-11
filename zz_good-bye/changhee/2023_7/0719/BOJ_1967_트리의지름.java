
/**
 * 7.19 김창희
 * 백준_1967_트리의 지름
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<List<Node>> graph = new ArrayList<>();

		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Node(y, cost));
			graph.get(y).add(new Node(x, cost));
		}

		//루트에서 가장 멀리 떨어진 정점을 찾고, 그 정점에서 가장 멀리 떨어진 정점을 찾는다.
		int[] dist = dijkstra(graph, 1, n);

		int idx = 1;
		for (int i = 1; i < n + 1; i++) {
			if (dist[i] > dist[idx])
				idx = i;
		}

		dist = dijkstra(graph, idx, n);
		int answer = Arrays.stream(dist).filter(v -> v != Integer.MAX_VALUE).max().getAsInt();
		System.out.println(answer);
	}

	public static int[] dijkstra(List<List<Node>> graph, int start, int n) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
		int[] dist = new int[n + 1];

		q.offer(new Node(start, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (dist[node.x] < node.cost)
				continue;

			for (Node thisNode : graph.get(node.x)) {
				if (dist[thisNode.x] > dist[node.x] + thisNode.cost) {
					dist[thisNode.x] = dist[node.x] + thisNode.cost;
					q.offer(new Node(thisNode.x, dist[thisNode.x]));
				}
			}
		}
		return dist;
	}

	static class Node {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}

}
