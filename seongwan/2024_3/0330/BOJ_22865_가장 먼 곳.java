import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//세 친구들로부터 거리가 가깝고 번호가 큰 순(작은 번호를 출력해야 하므로)으로 방문한 뒤
//제일 마지막에 방문했던 노드의 번호를 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static int[] start = new int[3];
	static List<int[]>[] adList;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		adList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adList[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			adList[from].add(new int[] {to, dis});
			adList[to].add(new int[] {from, dis});
		}

		dijk();
		System.out.println(ans);
	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] == e2[1] ? e2[0] - e1[0] : e1[1] - e2[1]);
		boolean[] visit = new boolean[N + 1];

		for (int i = 0; i < 3; i++) {
			pq.add(new int[] {start[i], 0});
		}

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cur = temp[0];

			if (visit[cur])
				continue;

			int dis = temp[1];

			visit[cur] = true;
			ans = cur;

			for (int[] next : adList[cur]) {
				int to = next[0];
				if (visit[to])
					continue;
				pq.add(new int[] {to, dis + next[1]});
			}
		}
	}
}