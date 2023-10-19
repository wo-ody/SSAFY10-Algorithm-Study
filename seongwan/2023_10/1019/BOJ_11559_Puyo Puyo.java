import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] board = new char[12][6];
	static Deque<Character> check = new ArrayDeque<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean pang;
	static boolean[] nopuyo = new boolean[6];// 뿌요가 없는 줄 체크
	static int ans;// 터진 횟수
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 12; i++) {
			board[i] = br.readLine().toCharArray();
		} // 보드판 입력

		while (true) {
			visit = new boolean[12][6];
			pang = false;
			for (int j = 0; j < 6; j++) {
				if (nopuyo[j])// 뿌요가 없는 줄은 넘어감
					continue;
				for (int i = 0; i < 12; i++) {
					if (board[i][j] != '.' && !visit[i][j]) {
						bfs(i, j, board[i][j]);
					}
				}
			}
			if (!pang)
				break;// 터진 뿌요가 없다면 종료
			ans++;// 터졌다면 횟수 추가

			down();// 터진 후 뿌요들을 바닥으로 내림
		}
		System.out.println(ans);

	}

	static void bfs(int i, int j, char c) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> temp = new ArrayDeque<>();// 4 이상이면 터트리기 위해 임시 저장
		queue.add(new int[] { i, j });
		visit[i][j] = true;
		temp.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc) && board[nr][nc] == c && !visit[nr][nc]) {
					queue.add(new int[] { nr, nc });
					temp.add(new int[] { nr, nc });
					visit[nr][nc] = true;// 방문 처리
				}
			}
		}
		if (temp.size() >= 4) {
			while (!temp.isEmpty()) {
				int[] cur = temp.poll();
				board[cur[0]][cur[1]] = '.';
				pang = true;
			}
		} // 터짐 처리
		temp.clear();

	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6)
			return true;
		return false;
	}

	static void down() {
		for (int j = 0; j < 6; j++) {
			if (nopuyo[j])// 뿌요가 없는 줄은 넘어감
				continue;
			for (int i = 0; i < 12; i++) {
				if (board[i][j] != '.') {
					check.push(board[i][j]);// 줄에 있는 모든 뿌요들을 담음
					board[i][j] = '.';// 비어있는 걸로 처리
				}
			}
			int size = check.size();
			if (size == 0)
				nopuyo[j] = true;// 뿌요가 없는 줄 체크
			for (int k = 11; k > 11 - size; k--) {
				board[k][j] = check.pop();
			} // 밑에서부터 뿌요 채워넣기
		}
	}

}