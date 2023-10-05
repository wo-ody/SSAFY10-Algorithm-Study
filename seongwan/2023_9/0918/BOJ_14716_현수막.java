import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {// 상,하,좌,우,대각선 인접 영역 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N, paper[][], cnt;// 세로,가로,현수막,글자의 개수
	static int dr[] = { -1, 0, 1, 0, -1, -1, 1, 1 };// 상 ,좌,하,우,좌상,우상,좌하,우하
	static int dc[] = { 0, -1, 0, 1, -1, 1, -1, 1 };// 상 ,좌,하,우,좌상,우상,좌하,우하

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		paper = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 현수막 정보 입력

		find();
		System.out.println(cnt);
	}

	static void find() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (paper[i][j] == 1) {
					cnt++;
					dfs(i, j);
//					print();
//					System.out.println();
				}
			}
		}

	}

	static void dfs(int i, int j) {
		paper[i][j] = 0;// 방문 처리
		for (int dir = 0; dir < 8; dir++) {
			int nr = i + dr[dir];
			int nc = j + dc[dir];
			if (cango(nr, nc))
				dfs(nr, nc);
		}

	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < M && c >= 0 && c < N && paper[r][c] == 1)
			return true;
		return false;
	}

//	static void print() {
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(paper[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//	}

}
