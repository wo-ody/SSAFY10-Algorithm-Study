package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1240_노드사이의_거리 {

	static int[][] graph;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		graph = new int[N + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			int n1, n2, dist;
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			dist = sc.nextInt();
			graph[n1][n2] = dist;
			graph[n2][n1] = dist;
		}

		for (int i = 0; i < M; i++) {
			int n1, n2;
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			bfs(n1, n2);
		}
	}

	static void bfs(int root, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		queue.add(root);
		visited[root] = true;

		int ans[] = new int[N + 1];
		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int i = 1; i < N + 1; i++) {
				if (i == dest) {

				}
				if (graph[node][i] != 0 && visited[i] == false) {
//					visited[i] = true;
					ans[i] += graph[node][i] + ans[node];

					if (i == dest) {
						System.out.println(ans[dest]);
						return;
					}

					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
