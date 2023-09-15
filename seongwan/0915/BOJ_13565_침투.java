import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0은 전류가 통함 , 1은 전류가 안 통함
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int M, N;// 세로,가로
	static char[][] map;
	static boolean flag;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		} // 맵 입력
		find();
		System.out.println(flag ? "YES" : "NO");
	}

	static void find() {
		for (int i = 0; i < N; i++) {
			if (map[0][i] == '0') {
				dfs(0, i);
				if (flag)
					return;
			}
		}
	}// 첫 행(바깥쪽)에서 전류가 흐를 수 있는 0을 찾고 있으면 dfs로 탐색

	static void dfs(int r, int c) {

		if (r == M - 1) {// dfs탐색 중 마지막 행(안쪽)에 도달하면 flag를 true로 하고 탐색 종료
			flag = true;
			return;
		}
		map[r][c] = '1';// 방문처리
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (cango(nr, nc))
				dfs(nr, nc);
		}

	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < M && c >= 0 && c < N && map[r][c] != '1')
			return true;
		return false;
	}
}
