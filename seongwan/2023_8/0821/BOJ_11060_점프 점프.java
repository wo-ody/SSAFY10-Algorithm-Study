import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] A;
	static int N;
	static int[] visited;// 점프 횟수를 체크하기 위해 int배열

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		visited = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());

		} // A입력
		if (N == 1)
			System.out.println(0);// N이 1일 경우 바로 도착이므로 0출력
		else {
			bfs();
			System.out.println(visited[N - 1] == 0 ? -1 : visited[N - 1]);
			// 끝 점에 도달하지 못한 경우 -1 출력 아니면 끝 점에 도달할 때까지의 점프 횟수 출력
		}
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (A[cur] == 0)
				continue;// 0일 때는 점프가 불가능하므로
			for (int i = 1; i <= A[cur]; i++) {
				int nx = cur + i;
				if (nx < N && visited[nx] == 0) {
					queue.add(nx);
					visited[nx] = visited[cur] + 1;
				}

			}
		}
	}
}
