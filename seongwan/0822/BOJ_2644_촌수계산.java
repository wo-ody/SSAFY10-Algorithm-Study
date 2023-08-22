import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer>[] adlist;
	static int n, A, B, m;// 전체 사람의 수,촌수를 계산해야 하는 사람,관계의 개수
	static int[] visited;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		adlist = new List[n + 1];
		visited = new int[n + 1];// 0은 더미
		for (int i = 1; i <= n; i++) {
			adlist[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adlist[from].add(to);
			adlist[to].add(from);
		} // 가족 관계를 인접리스트에 입력

		bfs();
		System.out.println(visited[B] == 0 ? -1 : visited[B] - 1);
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(A);
		visited[A] = 1;// 시작을 1로 했으므로 최종값에서 -1

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < adlist[cur].size(); i++) {
				int next = adlist[cur].get(i);
				if (visited[next] == 0) {
					visited[next] = visited[cur] + 1;
					queue.add(next);
				}
			}
		}
	}

}
