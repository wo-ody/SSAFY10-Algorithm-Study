import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, M, N, K, answer;
	static int[][] cabbages;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			answer = 0;
			cabbages = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cabbages[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cabbages[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						answer += 1;
					}
				}
			}

			System.out.println(answer);
		}
	}

	static void dfs(int y, int x) {
		visited[y][x] = true;
		if (0 < y) {
			if (cabbages[y - 1][x] == 1 && !visited[y - 1][x])
				dfs(y - 1, x);
		}
		if (y < N - 1) {
			if (cabbages[y + 1][x] == 1 && !visited[y + 1][x])
				dfs(y + 1, x);
		}
		if (0 < x) {
			if (cabbages[y][x - 1] == 1 && !visited[y][x - 1])
				dfs(y, x - 1);
		}
		if (x < M - 1) {
			if (cabbages[y][x + 1] == 1 && !visited[y][x + 1])
				dfs(y, x + 1);
		}
	}

}
