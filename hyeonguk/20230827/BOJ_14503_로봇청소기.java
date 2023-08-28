import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 북, 동, 남, 서
	static int dy[] = { -1, 0, 1, 0};
	static int dx[] = { 0, 1, 0, -1};
	static int N, M, answer;
	static int[][] room;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		answer = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(r, c, d);
		System.out.println(answer);
	}

	public static void dfs(int r, int c, int direction) {
		// 현재 위치 청소
		room[r][c] = -1;

		// 북, 동, 남, 서
		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;
			int ny = r + dy[direction];
			int nx = c + dx[direction];
			
			if (ny < 0 && ny >= N && nx < 0 && nx >= M) continue;
			
			if (room[ny][nx] == 0) {
				answer++;
				dfs(ny, nx, direction);

				return;
			}
		}

		int back = (direction + 2) % 4;
		int by = r + dy[back];
		int bx = c + dx[back];

		if (0 <= by  && by < N && 0 <= bx && bx < M && room[by][bx] != 1) {
			dfs(by, bx, direction);
		}
	}
}
