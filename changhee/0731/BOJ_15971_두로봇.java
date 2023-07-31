/*
 *	7.31 김창희
 *	BOJ_15971_두로봇
 *
 *	[풀이]
 *	1. 두 정점을 잇는 최소 비용 간선들 중 가장 큰 값을 삭제하면 된다
 *	2. 다익스트라를 사용하여 두 정점사이의 최소 거리를 구한다.
 *	3. 탐색 node에 max값을 하나 더 추가해서 최소 비용 거리를 구하는 경로중에 가장 큰 비용을 가진 간선을 저장한다.
 *	4. 두 정점사이의 최소거리에서 max값을 뺀다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken()),
				end = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Node(y, cost));
			graph.get(y).add(new Node(x, cost));
		}

		int answer = dijkstra(start, end, n);
		System.out.println(answer);
	}

	private static int dijkstra(int start, int end, int n) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

		q.offer(new Node(start, 0));
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (dist[node.x] < node.cost) continue;

			if (node.x == end) return dist[end] - node.max;

			for (Node thisNode : graph.get(node.x)) {
				if (dist[thisNode.x] > dist[node.x] + thisNode.cost) {
					dist[thisNode.x] = dist[node.x] + thisNode.cost;

					Node nNode = new Node(thisNode.x, dist[thisNode.x]);
					int max = Math.max(node.max, thisNode.cost);
					nNode.max = max;

					q.offer(nNode);
				}
			}
		}
		return 0;
	}

	static class Node {
		int x, cost, max;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}

	}
}
