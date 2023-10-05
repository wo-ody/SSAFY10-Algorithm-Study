import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int F, S, G, U, D;// 건물의 층 수,현재 층,목표 층,UP,DOWN
	static int[] visited;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new int[F + 1];// 0은 더미;
		visited[0] = 1;// 0을 방문하지 않게 하기 위해

		bfs(S);
		System.out.println(visited[G] == 0 ? "use the stairs" : visited[G] - 1);
		// 방문하지 못한다면 출력x 방문한다면 목표층의 visited-1을 출력
	}

	static void bfs(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		visited[n] = 1;// 시작점을 1로 했으므로 결과 -1
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int next = cur + U;
			if (next <= F && visited[next] == 0) {
				visited[next] = visited[cur] + 1;
				queue.add(next);
			}
			next = cur - D;
			if (next >= 1 && visited[next] == 0) {
				visited[next] = visited[cur] + 1;
				queue.add(next);
			}
		}
	}// 해당 층으로 갈 때 누를 수 있는 최소 횟수+1을 visited에 저장함
}
