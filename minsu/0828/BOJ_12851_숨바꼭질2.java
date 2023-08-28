package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
	static int N, K, ans, cnt;
	static int[] visited = new int[100001];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		if (N >= K) {
			ans = N - K;
			cnt = 1;
		} else {
			bfs(N);
		}

		System.out.println(ans + "\n" + cnt);
	}

	static void bfs(int n) {
		visited[n] = 1;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			// 탐색 진행시간이 구하려는 최단 시간보다 크다면 더 볼 필요가 없기 때문에 return
			if (ans < visited[cur]) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = cur - 1;
				} else if (i == 1) {
					next = cur + 1;
				} else {
					next = cur * 2;
				}

				if (next < 0 || next > 100000) {
					continue;
				}
				if (next == K) {
					ans = visited[cur];
					cnt++;
				}

				// next로 처음 가는거거나 큐에서 꺼낸 곳에서 3가지 방법 중 다른 방법으로도 next로 간다면 큐에 next를 넣어준다.
				// 즉, 중복 허용을 위해 큐에 next를 넣어주는 것
				if (visited[next] == 0 || visited[next] == visited[cur] + 1) {
					visited[next] = visited[cur] + 1;
					queue.offer(next);
				}

			}

		}
	}

}
