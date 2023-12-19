import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, D, ans;
	static int[][] road;
	static boolean[] visit = new boolean[10001];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		road = new int[N][3];// 지름길의 출발,도착,거리 정보

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());// 시작
			road[i][1] = Integer.parseInt(st.nextToken());// 도착
			road[i][2] = Integer.parseInt(st.nextToken());// 거리
		}
		ans = D;
		dijk();
		System.out.println(ans);

	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { 0, 0 });

		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			int s = cur[0];
			if (visit[s])
				continue;
			visit[s] = true;
			int weight = cur[1];

			if (s == D) {
				ans = weight;
				return;
			}

			ans = Math.min(ans, D - s + weight);

			for (int i = 0; i < N; i++) {
				if (s <= road[i][0] && road[i][1] <= D)
					pq.add(new int[] { road[i][1], road[i][0] - s + road[i][2] + weight });
			}
		}
	}
}