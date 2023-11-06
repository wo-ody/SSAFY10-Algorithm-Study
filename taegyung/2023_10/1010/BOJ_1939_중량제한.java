package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한 {
//	static ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();
//	static int[][] bridge_weight;

	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
//		bridge_weight = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
//			graph.add(new HashMap<>());
			graph.add(new ArrayList<>());
		}

		int max_weight = 0;
		int min_weight = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			max_weight = Math.max(max_weight, C);
			min_weight = Math.min(min_weight, C);
			graph.get(A).add(new Node(B, C));
			graph.get(B).add(new Node(A, C));
//			if (graph.get(A).get(B) == null || graph.get(A).get(B) < C)
//				graph.get(A).put(B, C);
//			if (graph.get(B).get(A) == null || graph.get(B).get(A) < C)
//				graph.get(B).put(A, C);

//			graph.get(B).add(A); // 이러면 그래프에 연결된 게 중복 없이 들어가게 된다.

			// C의 값을 저장하기 위해서는 이차원 배열에 저장하자.

			// 저장은 이차원 배열에 하고 연결 관계는 그래프를 탐색하면서 확인하면 될 것.
//			bridge_weight[A][B] = C;
//			bridge_weight[B][A] = C;

		}
		st = new StringTokenizer(br.readLine());
		int startNode = Integer.parseInt(st.nextToken());
		int endNode = Integer.parseInt(st.nextToken());

		int result = 0;
		while (min_weight <= max_weight) {
			visited = new boolean[N + 1];
			visited[startNode] = true;
			int middle = (min_weight + max_weight) / 2;

			if (bfs(startNode, endNode, middle)) {
				result = middle;
				min_weight = middle + 1;
			} else {
				max_weight = middle - 1;
			}

		}
		System.out.println(result);
//		visited[startNode] = true;

//		System.out.println(dfs(startNode, endNode,
//				graph.get(startNode).get(endNode) != null ? graph.get(startNode).get(endNode) : Integer.MAX_VALUE));
	}

	public static boolean bfs(int startNode, int endNode, int cost) {

		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int i = 0; i < graph.get(node).size(); i++) {

				if (graph.get(node).get(i).cost >= cost && !visited[graph.get(node).get(i).num]) {
					if (graph.get(node).get(i).num == endNode) { // 찾았다
						return true;
					}
					visited[graph.get(node).get(i).num] = true;
					queue.offer(graph.get(node).get(i).num);
				}
			}
		}
		return false;

	}

	static class Node {
		int num;
		int cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}

//	public static int dfs(int startNode, int endNode, int cost) {
//		int result = Integer.MIN_VALUE;
//		if (graph.get(startNode).get(endNode) != null) {
//			result = graph.get(startNode).get(endNode) < cost ? graph.get(startNode).get(endNode) : cost;
//		}
//
//		// 경로의 최소값으로 깎여나갈것이다.
//		// result를 계속해서 갱신하고 마지막에 리턴을 하자
//		ArrayList<Integer> keySet = new ArrayList<>(graph.get(startNode).keySet());
//		for (int i = 0; i < keySet.size(); i++) {
////			int [] tmp = graph.get(startNode).toArray();
//			if (!visited[keySet.get(i)]) {
//				visited[keySet.get(i)] = true;
//				result = Math.max(result,
//						dfs(keySet.get(i), endNode,
//								cost > graph.get(startNode).get(keySet.get(i)) ? graph.get(startNode).get(keySet.get(i))
//										: cost));
//				visited[keySet.get(i)] = false;
//			}
//		}
//
//		return result;
//	}
}
