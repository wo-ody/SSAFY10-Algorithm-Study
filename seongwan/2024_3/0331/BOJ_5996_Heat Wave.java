import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라로 출발점에서 도착점까지의 최소 가중치의 경우를 구하면 됨
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, C, start, end;
	static List<int[]>[] adlist;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		adlist = new List[T + 1];
		for (int i = 1; i <= T; i++) {
			adlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			adlist[from].add(new int[] { to, dis });
			adlist[to].add(new int[] { from, dis });
		}

		dijk();

	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		boolean[] visit = new boolean[T + 1];
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cur = temp[0];

			if (visit[cur])
				continue;

			int dis = temp[1];

			if (cur == end) {
				System.out.println(dis);
				return;
			}

			visit[cur] = true;

			for (int[] next : adlist[cur]) {
				int n = next[0];
				if (visit[n])
					continue;

				pq.add(new int[] { n, dis + next[1] });
			}
		}
	}
}