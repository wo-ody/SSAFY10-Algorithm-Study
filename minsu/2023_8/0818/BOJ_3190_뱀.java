package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 방향을 0, 1, 2, 3순으로 돌려주면서 초기 방향은 1로 설정 dir = 1;
 * 뱀의 움직임을 기록한 후, 3초 뒤에는 방향이 2가 됨 dir 1-> 2
 * D가 나오면 +1을 dir에 더해주고, L이 나오면 +3한 뒤에 나누기 4해서 dir 설정!
 */
public class BOJ_3190_뱀 {
	static int n, k, l, dir, ans, t; // 보드의 크기 n, 사과의 개수 k개, 방향 전환 횟수 l
	static Queue<int[]> apple = new ArrayDeque<>();
	static Deque<Turn> queue = new ArrayDeque<>(); // 방향 전환하는걸 담아놓을 큐
	static int[][] dxy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 사과 정보 입력받고
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			apple.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// 방향 전환 몇번하는지
		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			queue.offer(new Turn(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		// 첫 시작점 1-1부터 시작해서 뱀을 이동시키기
		dir = 1;
		solve(1, 1);
		System.out.println(ans);
	}

	static void solve(int x, int y) {
		Deque<Move> s_queue = new LinkedList<>();
		// 첫 시작점부터 넣어주고
		s_queue.offer(new Move(x, y));

		while (true) {
			boolean isApple = false;
			boolean isFail = false;
			ans++;
			int nx = x + dxy[dir][0];
			int ny = y + dxy[dir][1];
			// 다음으로 이동할 좌표가 만약 범위 밖이라면 패스
			if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
				break;
			}
			// 이동할 좌표가 뱀 좌표들 중에 있다면 패스
			for (Move snake : s_queue) {
				if (snake.x == nx && snake.y == ny) {
					isFail = true;
					break;
				}
			}
			// 몸통하고 부딪혔으면 그대로 빠져나옴
			if (isFail) {
				break;
			}
//			 이동 좌표에 사과가 있는지 확인해서 있다면 큐에 추가만 하고, 없다면 추가하고 삭제하고 -> 사과를 지워야 하는데
			Iterator<int[]> iterator = apple.iterator();
			while (iterator.hasNext()) {
				// 돌려보는데 사과가 존재하는 자리라면 큐에 그대로 추가하고 다음 스텝
				int[] apple = iterator.next();
				if (nx == apple[0] && ny == apple[1]) {
					iterator.remove();
					isApple = true;
					break;
				}
			}

			if (isApple) {
				s_queue.addFirst(new Move(nx, ny));
			} else {
				s_queue.addFirst(new Move(nx, ny));
				s_queue.pollLast();
			}

			// 방향 전환을 해야 할 때가 왔다면 방향만 바꿔주고
			Turn turn = queue.poll();
			if (turn != null) {
				if (ans == turn.time) {
					if (turn.dir.equals("D")) {
						dir = (dir + 1) % 4;
					} else if (turn.dir.equals("L")) {
						dir = (dir + 3) % 4;
					}
				} else {
					queue.addFirst(turn);
				}
			}
			x = nx;
			y = ny;
		}
	}

	static class Turn {
		int time;
		String dir;

		Turn(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	static class Move {
		int x;
		int y;

		Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
