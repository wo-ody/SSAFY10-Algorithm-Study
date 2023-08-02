package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인_해킹 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int INF = Integer.MIN_VALUE;
	static int N, M;
	static boolean[] visited;
	static int[] costs;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) { // 1부터 N까지 확인할거임
			graph.add(new ArrayList<Integer>()); // 배열 집어넣기
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(B).add(A); // 단방향 그래프 그리기
			// A 가 B 를 신뢰한다 니까 B에 넣어야겠음

		}
		costs = new int[N + 1];

		int max = -1;
		for (int i = 1; i < N + 1; i++) {
			costs[i] = dfs(i);
			max = Math.max(max, costs[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if (costs[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);

	}

	public static int dfs(int root) {
		boolean[] visited = new boolean[N + 1];

		Deque<Integer> stack = new ArrayDeque<>();

		stack.push(root);
		int cost = 0;
		visited[root] = true;
		while (!stack.isEmpty()) {
			int cNode = stack.pop();

			for (int nNode : graph.get(cNode)) {
				if (visited[nNode] == false) {
					visited[nNode] = true;
					stack.add(nNode);
					cost++;
				}
			}
		}
		return cost;

	}

}
