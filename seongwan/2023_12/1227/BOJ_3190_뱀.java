import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, L, count, dir, time, r, c;
	static int[][] board;
	static int[] turntime;
	static char[] turndir;
	static int[] dr = { 0, 1, 0, -1 };// 오른쪽 전환 기준 (dir+1)%4
	static int[] dc = { 1, 0, -1, 0 };
	static Queue<int[]> snake = new ArrayDeque<>();// 뱀의 좌표 저장

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];// 보드판 생성

		snake.add(new int[] { 1, 1 });
		r = 1;
		c = 1;// 뱀의 출발 좌표

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;// 사과는 1로 표시
		} // 사과 정보 board에 저장

		L = Integer.parseInt(br.readLine());
		turntime = new int[L];
		turndir = new char[L];

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			turntime[i] = Integer.parseInt(st.nextToken());
			turndir[i] = st.nextToken().charAt(0);
		} // 방향 전환 정보를 저장

		simulation();

	}

	static void simulation() {
		while (true) {
			time++;
			r += dr[dir];
			c += dc[dir];
			if (r < 1 || r > N || c < 1 || c > N) {// 게임 종료 조건(벽)
				System.out.println(time);
				return;
			}
			for (int[] s : snake) {// 게임 종료 조건(몸통)
				if (s[0] == r && s[1] == c) {
					System.out.println(time);
					return;
				}
			}

			snake.add(new int[] { r, c });// 뱀이 이동한 위치를 저장
			if (board[r][c] != 1) {// 뱀이 향한 곳에 사과가 없는 경우
				snake.poll();// 꼬리 부분을 줄임
			} else {
				board[r][c] = 0;// 사과 먹음 처리
			}

			if (count < L && time == turntime[count]) {
				if (turndir[count] == 'D') {// 오른쪽으로 90도 전환하는 경우
					dir = (dir + 1) % 4;
				} else {// 왼쪽으로 90도 전환하는 경우
					dir = (dir + 3) % 4;
				}
				count++;// 다음 방향 전환 시간을 알기 위한 인덱스 증가
			}
		}
	}
}