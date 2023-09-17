import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, visit[], cnt = 1;// 정점,간선,시작 정점,방문 체크,방문 순서
	static List<Integer>[] adlist;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		adlist = new List[N + 1];
		visit = new int[N + 1];// 0은 더미
		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adlist[from].add(to);
			adlist[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adlist[i], Collections.reverseOrder());
		} // 인접 리스트 안 내림차순 정렬(내림차순으로 탐색하기 위해)
		dfs(R);
		for (int i = 1; i <= N; i++) {
			sb.append(visit[i] + "\n");
		}//정점 1 부터 N까지 DFS방문 순서를 sb에 담음
		System.out.println(sb);
	}

	static void dfs(int n) {
		visit[n] = cnt++;
		for (Integer to : adlist[n]) {
			if (visit[to] == 0)
				dfs(to);
		}
	}

}
