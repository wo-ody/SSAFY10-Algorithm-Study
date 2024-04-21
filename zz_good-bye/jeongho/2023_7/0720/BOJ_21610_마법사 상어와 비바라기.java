package jul_2023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class BOJ_21610_마법사 상어와 비바라기 {

	// 방향벡터, 입력값이 1부터 시작이라 0번째 인덱스는 안 씀!
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	static int N, M, map[][], d, s;
	static int[][] cloud;
	static int[][] nextCloud;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][N];
		cloud = new int[N][N];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		cloud[N - 1][0] = 1;
		cloud[N - 1][1] = 1;
		cloud[N-2][0] = 1;
		cloud[N-2][1] = 1;

		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			d = Integer.parseInt(str[0]);
			s = Integer.parseInt(str[1]);
			nextCloud = new int[N][N];
			moveCloud();
			cloud = nextCloud;
		}
		System.out.println(cntWater());

	}

	static void moveCloud() {
		// 구름 이동
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j] == 1) {
					int nextY = i;
					int nextX = j;
					for (int k = 1; k <= s; k++) {
						nextY += dy[d];
						nextX += dx[d];
						if (nextX < 0) {
							nextX = N - 1;
						}
						if (nextY < 0) {
							nextY = N - 1;
						}
						if (nextX == N) {
							nextX = 0;
						}
						if (nextY == N) {
							nextY = 0;
						}
					}
					nextCloud[nextY][nextX] = 1;
				}
			}
		}
		

		// 바구니의 물 양 증가
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				// 구름이 있다면 물 증가 및 구름이 사라짐, 물 복사까지 진행
				if (nextCloud[y][x] >0) {
					map[y][x]++;
					nextCloud[y][x] = -1;
				}
				
			}
		}
		for(int y = 0;y<N;y++) {
			for(int x = 0;x<N;x++) {
				if(nextCloud[y][x]==-1) {
					copyWater(y, x);
				}
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] >= 2) {
					if (nextCloud[y][x] == 0) {
						nextCloud[y][x] = 1;
						map[y][x]-=2;
					}
				}
				if (nextCloud[y][x] == -1) {
					nextCloud[y][x] = 0;
				}
			}
		}
	}

	// 물복사
	static void copyWater(int y, int x) {
		for (int d = 2; d <= 8; d += 2) {
			int nextY = y + dy[d];
			int nextX = x + dx[d];
			if (!check(nextY, nextX)) {
				continue;
			}
				
			if (map[nextY][nextX] > 0) {
				map[y][x]++;
			}
		}
	}

	// 물 카운트
	static int cntWater() {
		int cnt = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				cnt += map[y][x];
			}
		}
		return cnt;
	}

	static boolean check(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		} else {
			return true;
		}
	}

	static void printMap() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.print(map[y][x] + " ");
			}
			System.out.println();
		}
	}

	static void printCloud() {
		System.out.println("\nCloud");
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.print(cloud[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
