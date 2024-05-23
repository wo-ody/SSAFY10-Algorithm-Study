import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static StringTokenizer st;
	static int[][] check;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, -1, 0, 1};
	static int ans;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		check = new int[N][N];

		//map 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//-1로 check 배열을 채움으로써 맵의 지나간 위치 체크
		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], -1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(dfs(i, j), ans);
			}
		}
		System.out.println(ans + 1);
	}

	static int dfs(int r, int c) {
		//이미 탐색한 위치라면 해당 위치에서의 갈 수 있는 최대 경로 리턴
		if (check[r][c] >= 0)
			return check[r][c];

		boolean count = false;
		int value = 0;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (cango(nr, nc) && map[nr][nc] > map[r][c]) {
				count = true;
				value = Math.max(value, dfs(nr, nc));
			}
		}

		return check[r][c] = count ? 1 + value : 0;
	}

	static boolean cango(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}