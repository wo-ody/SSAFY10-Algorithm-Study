package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V, E;

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new int[] { v, w });
			// 모든 연결된 간선 추가
//			graph.add(new int[] {u,v,w});
		}
		// 최단경로니까 다익스트라를 사용하면 될 것 같음.
		final int MAX = Integer.MAX_VALUE - 100;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		// 정점까지의 최소값

		int[] visited = new int[V + 1]; // 해당 지점까지의 최소값을 구할거임

		for (int i = 0; i <= V; i++) {
			visited[i] = MAX; // 초기화
		}

		int[] arr = { K, 0 }; // 시작지점
		visited[K] = 0;

		pq.add(arr);

		while (!pq.isEmpty()) {
			int[] node_arr = pq.poll();

			int n_node = node_arr[0];
			int n_weight = node_arr[1];

			for (int i = 0; i < graph.get(n_node).size(); i++) {
				int[] tmp = graph.get(n_node).get(i);
				if (visited[tmp[0]] > n_weight + tmp[1]) { // 더 짧은 경로가 존재한다.
					visited[tmp[0]] = n_weight + tmp[1];
					pq.offer(new int[] { tmp[0], visited[tmp[0]] });
				}
			}

//			for(int i = 1 ; i < V+1; i ++) {
//				if (graph[n_node][i] > )
//			}
		}

		for (int i = 1; i <= V; i++)
			System.out.println(visited[i] == MAX ? "INF" : visited[i]);

//		for (int i = 1; i < E + 1; i++) {
//			graph[i][i] = 0;
//			for (int j = 1; j < E + 1; j++) {
//				if (i != j) {
//					pq.add(e)
//				}
//			}
//		}
	}

}
