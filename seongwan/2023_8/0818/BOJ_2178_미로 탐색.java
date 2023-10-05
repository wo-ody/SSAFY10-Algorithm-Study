import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };// 상,하,좌,우 인접 칸 탐색
	static char[][] map_c;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];// 0은 더미
		map_c = new char[N][M];
		for (int i = 0; i < N; i++) {
			map_c[i] = br.readLine().toCharArray();

		} // 맵을 char 배열로 입력 받음

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = map_c[i - 1][j - 1] - '0';
			}
		} // char배열로 입력받은 맵을 숫자로 변환
		bfs(1, 1);// 1,1에서 시작
		System.out.println(map[N][M] - 1);
	}

	static void bfs(int r, int c) {// 갈 수 있는 최단거리 구하기
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		map[r][c] = 2;// 방문 체크를 맵에서 깊이마다 숫자를 올리는 식으로 진행
		// 총 깊이= 마지막 칸에 입력된 수 -1(첫 칸이 1인데 1을 피하기 위해 2로 입력했으므로)
		while (!queue.isEmpty()) {
			int[] v = queue.poll();
			int sr = v[0];
			int sc = v[1];
			for (int i = 0; i < 4; i++) {
				int nr = sr + dr[i];
				int nc = sc + dc[i];// 다음으로 가볼 칸
				if (nr >= 1 && nr <= N && nc >= 1 && nc <= M && map[nr][nc] == 1) {
					map[nr][nc] = map[sr][sc] + 1;// 깊이마다 1씩 늘려가며 map에 표시(방문 체크 역할도 됨)
					queue.add(new int[] { nr, nc });
				}

			}

		}

	}

}
