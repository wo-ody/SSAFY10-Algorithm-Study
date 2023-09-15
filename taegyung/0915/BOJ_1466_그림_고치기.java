package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1466_그림_고치기 {
	static int N, M;

	static char[][] paint;
	static int[][][] parents;

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		// 검은 그룹 속의 모든 쌍의 경로의 길이가 Manhattan distance와 같다
		// 이 말의 뜻은 하나의 영역에서 다른 영역으로 가는 데에 꼬불꼬불하지 않다는 뜻.

		// 또 최단경로로 도달할 수 있어야 한다는 뜻.

		// 검정칸 중 일부가 흰 색으로 바뀌었다. --> 흰색 중에 일부를 바꿔서 조건을 만족할 수 있는 최소

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		paint = new char[N][M];

		for (int i = 0; i < N; i++) {
			paint[i] = br.readLine().toCharArray();

		}

		parents = new int[N][M][2]; // 각 위치에서의 부모노드

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				parents[i][j] = new int[] { -1, -1 };
				if (paint[i][j] == '#')
					parents[i][j] = new int[] { i, j };
			}
		} // 흰색은 -1,-1. 검은색은 자기 자신을 참조

		// 하나의 영역 안에 존재하는 같은 열, 같은 행의 직진거리가 다 검은색으로 칠해지게

		// 이걸 반복하다보면 될 것 같긴하다.

		// 그럼 추가하고 네 방향을 확인하면서 같은 부모를 갖게 하면 될라나

		// 모든 행을 계속 훑으면서 처음 만난 검은색과 나중 만난 검은색까지 다 검은색을 칠해
		// 칠하는 모든 검은색 칸에 대해 네 방향을 확인하면서 어떤 부모를 갖고 있는지 계속 수집
		// 이걸 set으로 수집 해두고 모든 원소에 속하는 노드들을 다시 union find 해야하나.

		// 연결 됐다 -> 를 어떻게 구현하지
		// 단순히 bfs?

//		for(int i = 0 ; i < N ; i ++) {
//			for()
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (paint[i][j] == '#' && (parents[i][j][0] == i && parents[i][j][1] == j)) {
					bfs(new int[] { i, j });
				}
			}
		}
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(Arrays.toString(parents[i][j]) + " ");
//
//			}
//			System.out.println();
//		}

//		parents[0][0][0] = 1;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(Arrays.toString(parents[i][j]) + " ");
//
//			}
//			System.out.println();
//		}

		// 그럼 이제 모든 열을 순회하면서 처음 나오는 시점 -> 다음 나오는 시점 사이에 있는 모든 paint를 #으로 칠하고
		// parents 들을 같은 애로 바꾼다.

		//
		// 네 방향으로 확인하면서 부모가 다르다 ? 부모에 접근해서 바꾼다.
		// 같아도 하면 되겟따.

		for (int i = 0; i < 5; i++) {
			horizontal();
			vertical();
			horizontal();
			vertical();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
//			sb.append(paint[i][])
//			System.out.println(paint[i].toString());
			for (int j = 0; j < M; j++) {
				sb.append(paint[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
//		horizontal();
//		vertical();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(Arrays.toString(parents[i][j]) + " ");
//
//			}
//			System.out.println();
//		}

	}

	static void bfs(int[] root) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(root);
		int x = root[0];
		int y = root[1];
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (paint[nx][ny] != '#')
					continue;
				if (parents[x][y][0] != parents[nx][ny][0] || parents[x][y][1] != parents[nx][ny][1]) {
					// 서로의 루트가 다르다.
					merge_root(x, y, nx, ny);
					queue.offer(new int[] { nx, ny });
				}

			} // visited는 따로 만들지 않아도 될 것.
		} // 일단 하나 바꾸었을 떄 다 바뀌는지 확인한번 해보자 // 안돼

	}

	static void vertical() {
		for (int j = 0; j < M; j++) {
//			int first = -1;
//			int last = -1;
			ArrayList<int[]> rootList = new ArrayList<>();
			ArrayList<Integer> first = new ArrayList<>();
			ArrayList<Integer> last = new ArrayList<>();

//			boolean flag = false;
			int[] root = { -1, -1 };
			for (int i = 0; i < N; i++) {// find root 진행한 결과로 확인해야겠네
				if (paint[i][j] == '#') {
					boolean flag = false;
					parents[i][j] = find_root(i, j);
					int[] tRoot = find_root(i, j);
					for (int r = 0; r < rootList.size(); r++) {
						if (tRoot[0] == rootList.get(r)[0] && tRoot[1] == rootList.get(r)[1]) {
//							if ()
							last.set(r, i);
							flag = true;
							break;
						}
					}

					if (!flag) {
						// 처음 들어온 녀석임
						// last에도 추가해야 무결성을 지킴
						first.add(i);
						rootList.add(tRoot);
						last.add(-1);
					}
				}
			}
			// 처음부터 last까지 확인하면서 다 검은색으로 칠함

			// last가 -1이 아닌 인덱스만 다 칠하면 되겠다.
			for (int l = 0; l < last.size(); l++) {
				if (last.get(l) != -1) {
					for (int i = first.get(l) + 1; i < last.get(l); i++) {
						paint[i][j] = '#';
						if (parents[i][j][0] == -1) { // 원래 하얀색이였다.
							parents[i][j][0] = parents[first.get(l)][j][0];
							parents[i][j][1] = parents[first.get(l)][j][1];
							// 그냥 더해줌

						}

						// 공통적으로 네 방향을 확인하면서 현재 루트와 확인하는 방향의 루트를 merge한다.

						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];

							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if (paint[nx][ny] != '#')
								continue;
							if (i < nx || (i == nx && j < ny)) {
								merge_root(i, j, nx, ny);
							} else {
								merge_root(nx, ny, i, j);
							}
						}
					}
				}
			}
//			if (flag && last != -1) {
//				for (int j = first + 1; j < last; j++) {
//					paint[i][j] = '#';
//					if (parents[i][j][0] == -1) { // 원래 하얀색이였다.
//						parents[i][j][0] = parents[i][first][0];
//						parents[i][j][1] = parents[i][first][1];
//						// 그냥 더해줌
//
//					}
//
//					// 공통적으로 네 방향을 확인하면서 현재 루트와 확인하는 방향의 루트를 merge한다.
//
//					for (int d = 0; d < 4; d++) {
//						int nx = i + dx[d];
//						int ny = j + dy[d];
//
//						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
//							continue;
//						if (paint[nx][ny] != '#')
//							continue;
//						if (i < nx || (i == nx && j < ny)) {
//							merge_root(i, j, nx, ny);
//						} else {
//							merge_root(nx, ny, i, j);
//						}
//					}
//				}
//			}
		}
	}

	static void horizontal() {
		for (int i = 0; i < N; i++) {
//			int first = -1;
//			int last = -1;
			ArrayList<int[]> rootList = new ArrayList<>();
			ArrayList<Integer> first = new ArrayList<>();
			ArrayList<Integer> last = new ArrayList<>();

//			boolean flag = false;
			int[] root = { -1, -1 };
			for (int j = 0; j < M; j++) {// find root 진행한 결과로 확인해야겠네
				if (paint[i][j] == '#') {
					boolean flag = false;
					parents[i][j] = find_root(i, j);
					int[] tRoot = find_root(i, j);
					for (int r = 0; r < rootList.size(); r++) {
						if (tRoot[0] == rootList.get(r)[0] && tRoot[1] == rootList.get(r)[1]) {
//							if ()
							last.set(r, j);
							flag = true;
							break;
						}
					}

					if (!flag) {
						// 처음 들어온 녀석임
						// last에도 추가해야 무결성을 지킴
						first.add(j);
						rootList.add(tRoot);
						last.add(-1);
					}
				}
			}
			// 처음부터 last까지 확인하면서 다 검은색으로 칠함

			// last가 -1이 아닌 인덱스만 다 칠하면 되겠다.
			for (int l = 0; l < last.size(); l++) {
				if (last.get(l) != -1) {
					for (int j = first.get(l) + 1; j < last.get(l); j++) {
						paint[i][j] = '#';
						if (parents[i][j][0] == -1) { // 원래 하얀색이였다.
							parents[i][j][0] = parents[i][first.get(l)][0];
							parents[i][j][1] = parents[i][first.get(l)][1];
							// 그냥 더해줌

						}

						// 공통적으로 네 방향을 확인하면서 현재 루트와 확인하는 방향의 루트를 merge한다.

						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];

							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if (paint[nx][ny] != '#')
								continue;
							if (i < nx || (i == nx && j < ny)) {
								merge_root(i, j, nx, ny);
							} else {
								merge_root(nx, ny, i, j);
							}
						}
					}
				}
			}
//			if (flag && last != -1) {
//				for (int j = first + 1; j < last; j++) {
//					paint[i][j] = '#';
//					if (parents[i][j][0] == -1) { // 원래 하얀색이였다.
//						parents[i][j][0] = parents[i][first][0];
//						parents[i][j][1] = parents[i][first][1];
//						// 그냥 더해줌
//
//					}
//
//					// 공통적으로 네 방향을 확인하면서 현재 루트와 확인하는 방향의 루트를 merge한다.
//
//					for (int d = 0; d < 4; d++) {
//						int nx = i + dx[d];
//						int ny = j + dy[d];
//
//						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
//							continue;
//						if (paint[nx][ny] != '#')
//							continue;
//						if (i < nx || (i == nx && j < ny)) {
//							merge_root(i, j, nx, ny);
//						} else {
//							merge_root(nx, ny, i, j);
//						}
//					}
//				}
//			}
		}
	}

	static void merge_root(int x1, int y1, int x2, int y2) { // 넣을 때 한쪽으로 몰면 되긴해
		int[] tmp1 = find_root(x1, y1);
		int[] tmp2 = find_root(x2, y2);

		parents[tmp2[0]][tmp2[1]] = tmp1;

	}

	static int[] find_root(int x, int y) {
		if (parents[x][y][0] == x && parents[x][y][1] == y) {
			return new int[] { x, y };
		}

		return parents[x][y] = find_root(parents[x][y][0], parents[x][y][1]);
	} // 이렇게 리턴이 되면 다 같은 주소를 참조하게 되나? 하나만 바꿔도 되게?

}
