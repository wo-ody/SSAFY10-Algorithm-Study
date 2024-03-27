//인접 리스트로 간선 정보를 다 저장한 후
//시작점부터 다익스트라를 통해 가중치가 적게 드는 경우만을 탐색 후
//도착점에 도달하면 종료

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, start, end;
	static List<int[]>[] edgeList;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edgeList = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}

		//간선 정보 추가
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList[from].add(new int[] {to, weight});
			edgeList[to].add(new int[] {from, weight});
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijk();
	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		boolean[] visit = new boolean[n + 1];

		for (int[] next : edgeList[start]) {
			pq.add(next);
		}
		visit[start] = true;

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cur = temp[0];

			if (visit[cur])
				continue;

			int weight = temp[1];

			//종료 조건
			if (cur == end) {
				System.out.println(weight);
				return;
			}

			visit[cur] = true;

			for (int[] nextEdge : edgeList[cur]) {
				int next = nextEdge[0];
				if (visit[next])
					continue;
				int nextW = nextEdge[1];
				pq.add(new int[] {next, weight + nextW});
			}
		}
	}
}