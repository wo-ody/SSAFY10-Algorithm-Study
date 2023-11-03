package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17822_원판_돌리기 {
	static int N, M;
	static Board[] boards;
	static boolean[][] visited;
	static boolean changed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		boards = new Board[N + 1]; // 0번째는 비워두자
//		int  
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			boards[i] = new Board();
			for (int j = 0; j < M; j++) {
				boards[i].nums[j] = Integer.parseInt(st.nextToken());
			} // 입력 완료

		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				if (i % x == 0) { // 돌려야할 원판
					boards[i].change_idx(d, k);
				}
			}
			// TODO debug
//			System.out.println("회전 후 :");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 0; j < M; j++) {
//
//					System.out.print(boards[i].get_num_by_index(j) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			// 다 돌렸다면 전체 확인하면서 인접한 애들 확인해야함.
			// 확인할 때 하나씩 잡으면서 네 방향으로 확인, 같다 ? bfs로 확인하고 다시 넣는것까지 귀찮네
			visited = new boolean[N + 1][M];

			changed = false;
			int beforeCnt = 0;
			for (int i = 1; i <= N; i++) {
				int[] ttmp = boards[i].remain_nums();
				beforeCnt += ttmp[1];
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j])
						bfs(i, j);
				}

			}
			int afterCnt = 0;
			for (int i = 1; i <= N; i++) {
				int[] ttmp = boards[i].remain_nums();
				afterCnt += ttmp[1];
			}
			// 다 돌아도 changed가 false다 ? 그럼 평균을 구해서 값들을 수정해야함.
			if (beforeCnt == afterCnt) {
				int sum = 0;
				int cnt = 0;

				for (int i = 1; i <= N; i++) {
					int[] tmp = boards[i].remain_nums();
					sum += tmp[0];
					cnt += tmp[1];
				}

				double avg = ((double) sum) / cnt;

				for (int i = 1; i <= N; i++) {
					boards[i].change_nums_by_avg(avg);
				}
//				System.out.println("변화 없음, 평균 : ");
//				System.out.println(avg);
			}
			// TODO debug
//			System.out.println("결과 :");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 0; j < M; j++) {
//
//					System.out.print(boards[i].get_num_by_index(j) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int sum = 0;
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			int[] tmp = boards[i].remain_nums();
			sum += tmp[0];
			cnt += tmp[1];
		}

		System.out.println(sum);
	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		boolean flag = false; // 처음 목표를 지워도 되는지를 확인하자
		int target = boards[x].get_num_by_index(y); // 돌아간 거에 맞춰서 수를 넘겨줄 것.
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];

				// x는 밖으로 나가면 안되지만 y 는 나가도 돼
				if (nx < 1 || nx > N)
					continue;

				ny = (ny + M) % M; // 0보다 작거나 M을 넘어간 경우 순회해서 돌아올 수 있다.
				if (visited[nx][ny])
					continue;

				if (boards[nx].get_num_by_index(ny) == target) { // 찾던 그 수다.
					flag = true;
//					changed = true;
					boards[nx].delete_num(ny);
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}

		}
		if (flag) { // 처음 목표를 지워야지
			boards[x].delete_num(y);
//			changed = true;

		}
	}

	public static class Board {
//		int ; // 몇번 째 보드인지는 별로 상관이 없긴 하네
		int[] nums = new int[M];
		int startIdx = 0;

		boolean[] done = new boolean[M];

		Board() {

		}

		void change_nums_by_avg(double avg) {
			for (int i = 0; i < M; i++) {
				if (!done[i]) {
					if (nums[i] > avg)
						nums[i] -= 1;
					else if (nums[i] < avg)
						nums[i] += 1;
				}
			}
		}

		int[] remain_nums() { // {sum,cnt};
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < M; i++) {
				if (!done[i]) {
					sum += nums[i];
					cnt += 1;
				}
			}
			return new int[] { sum, cnt };
		}

		void delete_num(int index) {
			done[(startIdx + index) % M] = true;
		}

		void change_idx(int direction, int cnt) {
//			if (direction == 1)
//				direction = -1;
			if (direction == 0)
				direction = -1;
			// direction == 0 : 시계방향으로 회전 => 시작 인덱스는 -1로 해야 돌아간 걸 표현함

			for (int i = 0; i < cnt; i++) {
				startIdx = (startIdx + M + direction) % M;
			} // 이러면 계속해서 순환하는 구조를 표현할 수 있을 것이다.
		}

		int get_num_by_index(int index) {
			if (!done[(startIdx + index) % M]) // 이 위치에 값이 아직 있다.
				return nums[(startIdx + index) % M];
			return -1; // 이 위치에 있는 값이 없을 때.
		} // 이걸로 해당 위치에서의 값을 얻어낼 수 있음.
	}
}
