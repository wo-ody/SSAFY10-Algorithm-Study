import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, W, B, cw, cb;// 가로,세로,우리팀 위력,적팀 위력,영역당 우리팀/적팀 수
	static char[][] map;// 맵
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 }; // 탐색 방향

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		} // 맵 입력

		find();
		System.out.println(W + " " + B);

	}

	static void find() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'W') {// 영역이 우리팀의 영역인 경우
					cw = 0;// 영역당 우리팀의 수 초기화
					dfs(i, j, 'W');// 영역에 몇 명이 있는지 확인
					W += cw * cw;// 영역에 있는 수를 제곱해 총 위력에 더해줌
				} else if (map[i][j] == 'B') {// 적팀의 경우
					cb = 0;
					dfs(i, j, 'B');
					B += cb * cb;
				}
			}
		}
	}

	static void dfs(int r, int c, char team) {
		if (team == 'W')
			cw++;
		else
			cb++;
		map[r][c] = '#';// 방문처리
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (cango(nr, nc, team))
				dfs(nr, nc, team);
		}

	}

	static boolean cango(int r, int c, char team) {
		if (r >= 0 && r < M && c >= 0 && c < N && map[r][c] == team)
			return true;
		return false;
	}

}
