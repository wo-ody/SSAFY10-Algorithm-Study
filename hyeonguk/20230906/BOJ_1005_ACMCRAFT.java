import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, K, W;
	static int[] dp; // dp용 배열
	static int[] costs; // 건물 짓는 시간 비용
	static int[] indegree; // 진입 차수
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			dp = new int[N + 1];
			costs = new int[N + 1];
			list = new ArrayList[N + 1];
			indegree = new int[N + 1];

			// 각 건물당 건설에 걸리는 시간 비용 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}

			// 간선 연결 정보를 저장할 리스트 초기화
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			//
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				indegree[to] += 1;
			}

			W = Integer.parseInt(br.readLine());

			for(int i=1; i<=N; i++) {
				dp[i] = costs[i];
			}
			dp[1] = costs[1];
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}

			while (!queue.isEmpty()) {
				int now = queue.poll();
				int size = list[now].size();
				for (int i = 0; i < size; i++) {
					int nextBuilding = list[now].get(i);

					indegree[nextBuilding]--;

					dp[nextBuilding] = Math.max(dp[nextBuilding], dp[now] + costs[nextBuilding]);

					if (indegree[nextBuilding] == 0)
						queue.offer(nextBuilding);
				}

			}

			System.out.println(dp[W]);
		}

	}

}
