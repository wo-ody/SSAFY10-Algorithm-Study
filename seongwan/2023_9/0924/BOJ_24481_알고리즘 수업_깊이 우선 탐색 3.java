import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, R;
	static List<Integer>[] adlist;
	static int[] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visit = new int[N + 1];
		adlist = new List[N + 1];

		Arrays.fill(visit, -1);// 방문 처리를 위해 -1로 모두 초기화

		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<Integer>();
		} // 인접리스트 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adlist[from].add(to);
			adlist[to].add(from);
		} // 간선 정보 입력
		visit[R] = 0;
		dfs(R, 1);
		for (int i = 1; i <= N; i++) {
			System.out.println(visit[i]);
		}
	}

	static void dfs(int n, int cnt) {
		Collections.sort(adlist[n]);
		for (Integer i : adlist[n]) {
			if (visit[i] == -1) {
				visit[i] = cnt;
				dfs(i, cnt + 1);

			}
		}
	}
}
