package algorithm2023.oct.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100_2048_Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, ans;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		//입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		//0번째 이동부터 시작
		game(0, board);

		System.out.println(ans);
	}

	static void game(int idx, int[][] board) {
		//5번 이동했다면
		if (idx == 5) {
			// 카운트 해서 최댓값 갱신
			ans = Math.max(ans, getMax(board));
			return;
		}
		
		// 배열 복사
		int[][] temp = new int[N][];
		for (int i = 0; i < N; i++) {
			temp[i] = board[i].clone();
		}

		for (int d = 0; d < 4; d++) {

			// d방향으로 밀기 및 합치기
			push(d, temp);
			// 다음 인덱스로 탐색
			game(idx + 1, temp);
			
			
			for (int i = 0; i < N; i++) {
				temp[i] = board[i].clone();
			}

		}
	}

	//배열에서 가장 큰 값 리턴
	static int getMax(int[][] board) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > max)
					max = board[i][j];
			}
		}
		return max;
	}

	//주어진 방향으로 미는 함수
	static void push(int d, int[][] board) {
		//각 방향마다 인덱스가 달라 각각 구현
		switch (d) {
		case 0:

			for (int i = 0; i < N; i++) {
				ArrayDeque<Integer> st = new ArrayDeque<>();
				int y = N - 1;
				int x = i;
				//N-1, i부터 시작하여 0이 아닌 값 모두 스택에 저장.
				while (y >= 0) {
					if (board[y][x] > 0) {
						st.push(board[y][x]);
						//스택에 넣은 이후에는 0으로 갱신
						board[y][x] = 0;
					}
					y += dy[d];
					x += dx[d];
				}
				//스택이 비어있다면 더이상 진행 x
				if (st.isEmpty())
					continue;
				y = 0;
				x = i;
				//이전 값과 다음 값을 비교하여 merge하여 배치할 지 그냥 배치할 지 저장.
				int prev = st.pop();
				while (!st.isEmpty()) {
					int next = st.pop();
					//이전 값과 새로운 값이 같다면 merge된 값 (2가 곱해진 값)을 저장 후 prev 값 초기화
					if (next == prev) {
						board[y++][x] = next * 2;
						prev = 0;
					} else {
						if (prev > 0) {
							//이전에 저장된 값이 있다면 이전 값 배치
							board[y++][x] = prev;
						}
					
						prev = next;
					}
				}
				board[y][x] = prev;
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				ArrayDeque<Integer> st = new ArrayDeque<>();
				int y = i;
				int x = 0;
				while (x < N) {
					if (board[y][x] > 0) {
						st.push(board[y][x]);
						board[y][x] = 0;
					}
					y += dy[d];
					x += dx[d];
				}
				if (st.isEmpty())
					continue;
				y = i;
				x = N - 1;
				int prev = st.pop();
				while (!st.isEmpty()) {
					int next = st.pop();
					if (next == prev) {
						board[y][x--] = next * 2;
						prev = 0;
					} else {
						if (prev > 0) {
							board[y][x--] = prev;

						}
						prev = next;
					}
				}
				board[y][x] = prev;
			}
			break;

		case 2:
			for (int i = 0; i < N; i++) {
				ArrayDeque<Integer> st = new ArrayDeque<>();
				int y = 0;
				int x = i;
				while (y < N) {
					if (board[y][x] > 0) {
						st.push(board[y][x]);
						board[y][x] = 0;
					}
					y += dy[d];
					x += dx[d];
				}
				if (st.isEmpty())
					continue;
				y = N - 1;
				x = i;
				int prev = st.pop();
				while (!st.isEmpty()) {
					int next = st.pop();
					if (next == prev) {
						board[y--][x] = next * 2;
						prev = 0;
					} else {
						if (prev > 0) {
							board[y--][x] = prev;
						}
						prev = next;
					}
				}
				board[y][x] = prev;
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				ArrayDeque<Integer> st = new ArrayDeque<>();
				int x = N - 1;
				int y = i;
				while (x >= 0) {
					if (board[y][x] > 0) {
						st.push(board[y][x]);
						board[y][x] = 0;
					}
					y += dy[d];
					x += dx[d];
				}
				if (st.isEmpty())
					continue;
				y = i;
				x = 0;
				int prev = st.pop();
				while (!st.isEmpty()) {
					int next = st.pop();
					if (next == prev) {
						board[y][x++] = next * 2;
						prev = 0;
					} else {
						if (prev > 0) {
							board[y][x++] = prev;
						}
						prev = next;
					}
				}
				board[y][x] = prev;
			}
			break;
		}

	}

	static void print(int[][] board) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
	}

	static boolean compare(int[][] board, int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != temp[i][j])
					return true;
			}
		}
		return false;
	}
}
