import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, X, Y;
	static int[] memo;
	static List<int[]>[] adlist;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		memo = new int[N];

		Arrays.fill(memo, -1);

		adlist = new List[N];
		for (int i = 0; i < N; i++) {
			adlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			adlist[from].add(new int[] { to, dis });
			adlist[to].add(new int[] { from, dis });
		}

		dijk();

		Arrays.sort(memo);

		int day = 0;
		int temp = 0;

		if (memo[0] == -1 || memo[N - 1] > X) {
			System.out.println(-1);
			return;
		}

		for (int i = 1; i < N; i++) {
			if (temp + memo[i] * 2 > X) {
				day++;
				temp = 0;
			}

			temp += memo[i] * 2;

		}

		System.out.println(day + 1);
	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		pq.add(new int[] { Y, 0 });

		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int to = temp[0];

			int dis = temp[1];

			if (memo[to] != -1)
				continue;

			cnt++;
			memo[to] = dis;

			if (cnt == N)
				return;

			for (int[] next : adlist[to]) {
				int nextNode = next[0];
				int nextDis = next[1] + dis;

				if (memo[nextNode] == -1)
					pq.add(new int[] { nextNode, nextDis });
			}
		}
	}
}