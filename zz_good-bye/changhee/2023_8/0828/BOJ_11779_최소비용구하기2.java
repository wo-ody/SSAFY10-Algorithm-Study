/*
 *  08.28 김창희
 *  BOJ_11779_최소비용구하기2
 *
 *  [풀이]
 *  1. 최소비용은 다익스트라로 구한다.
 *  2. 경로를 구하기 위해 최소비용을 구할때 마다 현재 노드로 오기전 노드를 배열에 저장한다.
 *  3. 배열을 인자로 넘겨 재귀를 통해 역추적하며 경로를 완성한다.
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
	static int n, m;
	static List<List<Node>> graph = new ArrayList<>();
	static int[] course;
	static StringBuilder distAnswer = new StringBuilder();
	static StringBuilder courseAnswer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		course = new int[n + 1];
		for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Node(y, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int minDist = dijkstra(start, end);
		distAnswer.append(minDist).append("\n");

		findRoute(end, start, 1);
		courseAnswer.append(end).append(" ");

		distAnswer.append("\n").append(courseAnswer);
		System.out.println(distAnswer);
	}

	public static void findRoute(int start, int end, int count) {
		if (end == course[start]) {
			courseAnswer.append(end).append(" ");
			distAnswer.append(count + 1);
			return;
		}
		findRoute(course[start], end, count + 1);
		courseAnswer.append(course[start]).append(" ");
	}

	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		int[] dist = new int[n + 1];

		q.offer(new Node(start, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (dist[node.x] < node.cost) continue;

			for (Node nNode : graph.get(node.x)) {
				if (dist[nNode.x] > dist[node.x] + nNode.cost) {
					course[nNode.x] = node.x;
					dist[nNode.x] = dist[node.x] + nNode.cost;
					q.offer(new Node(nNode.x, dist[nNode.x]));
				}
			}
		}
		return dist[end];
	}

	static class Node {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}
