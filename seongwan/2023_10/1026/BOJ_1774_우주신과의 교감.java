import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static boolean visit[];
	static double[][] edge;
	static double ans;
	static int[][] gods;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edge = new double[N + 1][N + 1];
		visit = new boolean[N + 1];
		gods = new int[N + 1][2];// 우주신들 좌표 정보
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			gods[i][0] = Integer.parseInt(st.nextToken());
			gods[i][1] = Integer.parseInt(st.nextToken());
		} // 우주신들 좌표를 입력

		makeedge();// 좌표별 거리를 구해서 인접행렬 구함

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edge[from][to] = 0;
			edge[to][from] = 0;
		} // 이미 연결되어 있는 신들의 cost 0처리

		prim();
		System.out.println(String.format("%.2f", ans));

	}

	static void makeedge() {
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				long dx = gods[i][0] - gods[j][0];
				long dy = gods[i][1] - gods[j][1];
				double dis = Math.sqrt(dx * dx + dy * dy);
				edge[i][j] = dis;
				edge[j][i] = dis;
			}
		}
	}

	static void prim() {
		PriorityQueue<double[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1] >= 0 ? 1 : -1);
		int cnt = 0;
		pq.add(new double[] { 1, 0 });
		while (!pq.isEmpty()) {
			double cur[] = pq.poll();
			int to = (int) cur[0];
			if (visit[to])
				continue;
			double cost = cur[1];
			cnt++;
			ans += cost;
			if (cnt == N)
				return;
			visit[to] = true;
			for (int i = 1; i <= N; i++) {
				if (!visit[i])
					pq.add(new double[] { i, edge[to][i] });
			}
		}
	}
}