package algorithm2023.oct.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10217_KCM_Travel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int INF = Integer.MAX_VALUE;

	static int N, M, K, dp[][];
	static ArrayList<ArrayList<Ticket>> adjList;

	static class Ticket {
		int v, c, d;

		public Ticket(int v, int c, int d) {
			super();
			this.v = v;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Ticket [v=" + v + ", c=" + c + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			adjList = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			// 공항의 수 N
			N = Integer.parseInt(st.nextToken());
			// 최대 금액 M
			M = Integer.parseInt(st.nextToken());
			// 티켓의 수 K
			K = Integer.parseInt(st.nextToken());

			// 각 공항으로 m 시간 에 갈 때의 최소 비용 배열
			dp = new int[N + 1][M + 1];

			// 인접 리스트 생성
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}

			for (int i = 2; i <= N; i++) {
				Arrays.fill(dp[i], INF);
			}

			// 티켓 정보 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				// 출발지 u, 도착지 v, 비용 c, 소요 시간 d
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				adjList.get(u).add(new Ticket(v, c, d));
			}

			PriorityQueue<Ticket> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
			pq.add(new Ticket(1, 0, 0));

			for (int i = 1; i <= N; i++) {
				Collections.sort(adjList.get(i), (o1, o2) -> o1.d - o2.d);
			}

			// dijkstra
			while (!pq.isEmpty()) {
				Ticket cur = pq.poll();
				if (cur.d > dp[cur.v][cur.c]) {
					continue;
				}
				if(cur.v==N)
					break;

				for (Ticket next : adjList.get(cur.v)) {
					// 다음으로 가는 비용과 시간을 체크
					int nextD = cur.d + next.d;
					int nextC = cur.c + next.c;
					// 비용이 M을 초과하면 패스
					if (nextC > M)
						continue;

					// 다음 목적지까지 nextC금액에 갈 수 있는 최소시간보다 현재 시간이 작다면 
					if (nextD < dp[next.v][nextC]) {
						//해당 금액보다 돈을 많이 내면 무조건 갈 수 있으므로 배열 갱신, 더 많은 금액 중 더 짧은 시간이 있다면 갱신하지 않고 종료
						for (int i = nextC; i <= M; i++) {
							if (dp[next.v][i] <= nextD)
								break;
							dp[next.v][i] = nextD;
						}
						//pq에 삽입
						pq.add(new Ticket(next.v, nextC, nextD));
					}
				}
			}
		}

		System.out.println(dp[N][M] == INF ? "Poor KCM" : dp[N][M]);

	}

}
