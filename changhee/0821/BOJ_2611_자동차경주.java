/*
 *  08.21 김창희
 *  BOJ_2611_자동차경주
 *
 *  [풀이]
 *  1. 위상정렬을 통해 순차적으로 탐색한다.
 *  2. 도달하는 지점마다 dp로 최대값으로 갱신한다.
 *  3. 최대값으로 갱신할때 몇번 노드에서 들어오는지도 같이 저장한다.
 *  4. 연결되어있는 간선이 0이 되면 큐에넣어서 탐색을 이어간다.
 *  5. 탐색이 끝나면 노드들을 역추적하여 경로를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringBuilder answer = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<List<Node>> graph = new ArrayList<>();
		int[] e = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
			e[end]++;
		}

		Queue<Node> q = new ArrayDeque<>();
		int[] dp = new int[n + 1];

		int[][] result = new int[n + 1][2];

		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[1] = 0;
		q.offer(new Node(1, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (Node nNode : graph.get(node.x)) {

				if (dp[nNode.x] < dp[node.x] + nNode.cost) {
					dp[nNode.x] = dp[node.x] + nNode.cost;
				}

				// 최대값을 저장할때 이전노드의 번호도 같이 저장한다. 그리고 역추적!ㅌ
				// 다른 곳에서도 올수있기 때문에 모든 경로에서 x점 까지 올때까지 비교 하지 않아야 한다.
				if (dp[nNode.x] > result[nNode.x][1]) {
					result[nNode.x][0] = node.x;
					result[nNode.x][1] = dp[nNode.x];
				}
				if (--e[nNode.x] == 0) {
					if (nNode.x == 1) continue;	//출발지에 도달하면 사이클
					q.offer(new Node(nNode.x, dp[nNode.x]));
				}
			}

		}

		answer.append(dp[1]).append("\n").append("1 ");
		findRoute(result, 1);
		System.out.println(answer);

	}

	public static void findRoute(int[][] result, int x) {
		if (result[x][0] == 1) {
			answer.append(x).append(" ");
			return;
		}
		findRoute(result, result[x][0]);
		answer.append(x).append(" ");
	}

	static class Node {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}
