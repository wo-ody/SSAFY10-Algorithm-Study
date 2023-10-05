import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, K, X, depth;
	static boolean visit[];
	static List<Integer>[] adlist;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 도시의 개수
		M = Integer.parseInt(st.nextToken());// 도로의 개수
		K = Integer.parseInt(st.nextToken());// 거리 정보(최단 거리가 K인 도시 찾기)
		X = Integer.parseInt(st.nextToken());// 출발 도시의 번호
		visit = new boolean[N + 1];
		adlist = new List[N + 1];// 0은 더미
		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<>();
		} // 인접리스트 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adlist[from].add(to);

		} // 간선 정보 입력
		bfs(X);
		System.out.println(sb.length() == 0 ? -1 : sb);
	}

	static void bfs(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(x);
		visit[x] = true;
		while (!queue.isEmpty()) {
			if (depth == K) {
				List<Integer> ans = new ArrayList<>();
				ans.addAll(queue);
				Collections.sort(ans);
				for (Integer integer : ans) {
					sb.append(integer + "\n");
				}
				return;
			}

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int from = queue.poll();
				for (Integer to : adlist[from]) {
					if (!visit[to]) {
						visit[to] = true;
						queue.add(to);
					}
				}
			}
			depth++;//거리마다 +1
		}
	}

}
