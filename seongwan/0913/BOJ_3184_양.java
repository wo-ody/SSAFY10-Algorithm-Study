import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//. = 빈 필드, #= 울타리 , o= 양 , v=늑대
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, c_s, c_w, ans_s, ans_w;// 행,열,(영역 안)양의 수,(영역 안)늑대의 수 ,(결과)양의 수,늑대의 수
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		} // 맵 입력

		find();
		System.out.println(ans_s + " " + ans_w);
	}

	static void find() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'o' || map[i][j] == 'v') {//양이나 늑대가 있는 영역만 체크
					c_s = 0;
					c_w = 0;// 새 영역을 탐색할 때 영역 안 동물의 수 초기화
					dfs(i, j);
					if (c_s > c_w)// 영역 안 양의 수가 늑대보다 많다면
						ans_s += c_s;
					else// 늑대가 양보다 많거나 같다면
						ans_w += c_w;
				}
			}
		}
	}

	static void dfs(int r, int c) {// dfs로 탐색하면서 영역 안의 양과 늑대의 수 체크
		if (map[r][c] == 'o')
			c_s++;
		else if (map[r][c] == 'v')
			c_w++;
		map[r][c] = '#';// 탐색 후 방문 처리
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (cango(nr, nc)) {
				dfs(nr, nc);
			}
		}
	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C && map[r][c] != '#')
			return true;
		return false;
	}
}
