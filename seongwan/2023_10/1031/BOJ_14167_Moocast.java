import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {// mst를 구하는 중 가장 가중치가 큰 간선의 가중치가 정답
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] cows, mat;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		cows = new int[N][2];
		mat = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		} // 소들의 좌표 입력

		makeedge();// 간선 제작
		prim();
	}

	static void makeedge() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int dx = cows[i][0] - cows[j][0];
				int dy = cows[i][1] - cows[j][1];
				mat[i][j] = mat[j][i] = dx * dx + dy * dy;
			}
		}
	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		int cnt = 0, ans = 0;
		pq.add(new int[] { 0, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;
			int cost = cur[1];
			cnt++;
			ans = Math.max(ans, cost);
			if (cnt == N)
				System.out.println(ans);
			visit[to] = true;
			for (int i = 0; i < N; i++) {
				if (visit[i])
					continue;
				pq.add(new int[] { i, mat[to][i] });
			}
		}
	}

}