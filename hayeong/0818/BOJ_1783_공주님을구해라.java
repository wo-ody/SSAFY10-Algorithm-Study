import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_공주님을구해라 {

	// 명검 획득하지 않고 BFS
	// 명검까지 BFS+명검부터 공주까지 거리
	// 둘 중 최소인거
	// (1,1)부터 시작
	static int N, M, T;
	static int[][] board;
	static int[][] visited;

	static int swordX, swordY;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		// 초기화
		board = new int[N + 1][M + 1];
		visited = new int[N + 1][M + 1];

		// 입력 및 명검 위치 저장
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					swordX = i;
					swordY = j;
					board[i][j] = 1; // 명검획득하지 않은 경우, 공주까지의 거리를 구하기 위해 명검을 벽으로 처리
				}
			}
		}

		// 명검 획득하지 않은 경우
		bfs(1, 1);
		int normalDist = visited[N][M];

		// 방문에 걸린 시간 초기화
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited[i], 0);
		}

		// 명검 획득한 경우
		board[swordX][swordY] = 0; // 명검위치를 갈 수 있는 곳으로 변경
		bfsSword(1, 1); // 시작점에서 명검까지의 거리 구하기

		int swordDist = visited[swordX][swordY]; // 시작점에서 명검까지의 거리

		// 시간안에 도착 여부, 도착한다면 최소 값
		int dist = 0; // 최소 거리
		if (normalDist == 0 && swordDist == 0) { // 명검획득, 미획득 모두 공주에 도달할 수 없을 때
			System.out.println("Fail");
			return;
		} else if (normalDist != 0 && swordDist == 0) { // 명검 없이 공주에게 도달 가능할 때
			dist = normalDist;
		} else if (normalDist == 0 && swordDist != 0) { // 명검을 가지고서만 공주에게 도달 가능할 때
			swordDist += ((N - swordX) + (M - swordY)); // 명검까지의 거리 + 명검위치부터 공주까지의 거리(벽 부숨)
			dist = swordDist;
		} else { // 명검 획득, 미획득 모두 공주에게 도달 가능할 때
			swordDist += ((N - swordX) + (M - swordY)); // 명검까지의 거리 + 명검위치부터 공주까지의 거리(벽 부숨)
			dist = Math.min(normalDist, swordDist); // 두 거리중 최소값
		}

		if (dist <= T) { // 시간안에 도착 가능
			System.out.println(dist);
		} else { // 시간엔에 도착 불가능
			System.out.println("Fail");
		}

	}

	static void bfs(int x, int y) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(x); // x
		queue.add(y); // y
		visited[x][y] = 0;

		while (!queue.isEmpty()) {
			int curX = queue.poll();
			int curY = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (canGo(nx, ny)) {
					queue.add(nx);
					queue.add(ny);
					visited[nx][ny] = visited[curX][curY] + 1;
				}
			}
		}

	}

	static void bfsSword(int x, int y) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(x);
		queue.add(y);
		visited[x][y] = 0;
		while (!queue.isEmpty()) {
			int curX = queue.poll();
			int curY = queue.poll();
			if (curX == swordX && curY == swordY) { // 명검 위치에 도달하면 bfs 종료
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (canGo(nx, ny)) {
					queue.add(nx);
					queue.add(ny);
					visited[nx][ny] = visited[curX][curY] + 1;
				}
			}
		}
	}

	static boolean canGo(int x, int y) {
		if (x < 1 || x > N || y < 1 || y > M) { // 범위 밖일 때
			return false;
		}
		if (board[x][y] != 0) { // 벽일 때
			return false;
		}
		if (visited[x][y] != 0) { // 방문한 적이 있을 때
			return false;
		}
		return true;
	}
}
