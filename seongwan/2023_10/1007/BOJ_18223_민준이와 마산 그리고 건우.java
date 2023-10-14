import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E, P; // 정점의 수, 간선의 수 , 건우의 위치
	static List<int[]>[] adlist;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		adlist = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			adlist[i] = new ArrayList<>();
		} // 인접리스트 초기화

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adlist[from].add(new int[] { to, cost });
			adlist[to].add(new int[] { from, cost });// 양방향 그래프
		} // 간선 정보 입력

		int gunwoo = dijk(1, 0, P) + dijk(P, 0, V);// 건우까지 갔다가 마산으로 가는 최단경로 가중치
		System.out.println(gunwoo == dijk(1, 0, V) ? "SAVE HIM" : "GOOD BYE");
		// 건우를 구하고 마산을 도착한 최단경로의 가중치와 그냥 마산을 갔을 때의 최단경로의 가중치가 같다면 구할 수 있다고 판단

	}

	static int dijk(int start, int weight, int desti) {
		visit = new boolean[V + 1];// 방문 배열 초기화
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int from = cur[0];
			int cost = cur[1];
			visit[from] = true;// 가중치 기준으로 뽑았을 때 pq에서 먼저 나왔다면 방문처리
			if (from == desti) {// 최단 경로의 가중치를 반환
				return cost;
			}

			for (int[] next : adlist[from]) {
				int to = next[0];
				int pcost = next[1];
				if (!visit[to]) {
					pq.add(new int[] { to, cost + pcost });
					// 지나가는 간선의 도착 정점에 방문하지 않았다면 pq에 정점과 가중치를 더해서 추가
				}
			}
		}
		return 1000000;
	}

}