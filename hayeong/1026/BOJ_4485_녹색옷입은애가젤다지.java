import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


// 이차원 배열의 모든 요소를 정점으로 봄! -> 다익스트라!
public class BOJ_4485_녹색옷입은애가젤다지 {

	static int N;
	static int[][] map, cost;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static final int INF = Integer.MAX_VALUE;

	static StringBuilder sb = new StringBuilder();

	static class Edge {
		int x, y, c;

		Edge(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			// 초기화 및 값 입력
			map = new int[N][N];
			cost = new int[N][N]; // 시작점에서부터 현재 좌표까지의 최소비용을 관리
			// 입력처리 + cost 초기화
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}

			// 다익스트라 풀이
			dijkstra();
			sb.append("Problem " + t++ + ": " + cost[N - 1][N - 1] + "\n");

		}
		System.out.println(sb);
	}

	static void dijkstra() {
		cost[0][0] = map[0][0];
		pq.offer(new Edge(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = e.x + dx[d];
				int ny = e.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(e.c + map[nx][ny] < cost[nx][ny]) {
					cost[nx][ny] = e.c + map[nx][ny];
					pq.offer(new Edge(nx, ny, cost[nx][ny]));
				}
			}
		}
	}

}
