import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, map[][], map_c[][], max;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		map_c = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // map 입력

		for (int j = 0; j <= 99; j++) {
			max = Math.max(max, find(j));
		}
		System.out.println(max);
	}

	static int find(int num) {
		copymap();// 기존 맵을 탐색 과정 중 유지하기 위해 맵 복사
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map_c[i][j] > num) {
					cnt++;
					dfs(i, j, num);
				}
			}
		}
		return cnt;
	}

	static void dfs(int r, int c, int num) {
		map_c[r][c] = 0;// 방문처리
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (cango(nr, nc, num)) {
				dfs(nr, nc, num);
			}
		}
	}

	static boolean cango(int r, int c, int num) {
		if (r >= 0 && r < N && c >= 0 && c < N && map_c[r][c] > num)
			return true;
		return false;
	}

	static void copymap() {
		for (int i = 0; i < N; i++) {
			map_c[i] = Arrays.copyOf(map[i], N);
		}
	}

}
