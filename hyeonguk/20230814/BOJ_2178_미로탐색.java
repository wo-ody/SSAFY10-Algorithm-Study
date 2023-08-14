import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 동, 서, 남, 북
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, M;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				array[i][j] = tmp.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(array[N - 1][M - 1]);
	}

	static void bfs() {
		Queue<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] { 0, 0 });

		while (!queue.isEmpty()) {
			Integer[] item = queue.poll();
			int y = item[0];
			int x = item[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;

				if (array[ny][nx] == 1) {
					array[ny][nx] = array[y][x] + 1;
					queue.offer(new Integer[] { ny, nx });
				}
			}
		}
	}
}
