
/**
 * 7.18 김창희
 * 백준_6497_전력난
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int cost = 0;
			List<Node> graph = new ArrayList<>();
			parent = new int[m];

			if (m == 0 && n == 0)
				break;

			for (int i = 0; i < m; i++)
				parent[i] = i;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				graph.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
				cost += graph.get(i).cost;
			}

			Collections.sort(graph, (o1, o2) -> Integer.compare(o1.cost, o2.cost));
			int result = kruskal(graph, cost);
			answer.append(result).append("\n");
		}

		System.out.println(answer);
	}

	public static int kruskal(List<Node> graph, int cost) {
		for (Node node : graph) {
			if (isSameParent(node.x, node.y)) {
				union(node.x, node.y);
				cost -= node.cost;
			}
		}
		return cost;
	}

	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x > y)
			parent[x] = y;
		if (x < y)
			parent[y] = x;
	}

	private static int findParent(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findParent(parent[x]);
	}

	private static boolean isSameParent(int x, int y) {
		if (findParent(x) == findParent(y))
			return false;
		return true;
	}

	static class Node {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
