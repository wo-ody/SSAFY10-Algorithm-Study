import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] tMap;
	static int N, M, D;
	static int maxDeathCnt = 0;

	static boolean[] selectedArcher;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tMap = new int[N][M];
		selectedArcher = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(maxDeathCnt);

	}

	static void comb(int selectIdx, int selectCnt) {
		if (selectCnt == 3) {// 다 뽑았다.
			int killCnt = 0;
			// TODO map 을 deepcopy해서 넣어줘야함.
			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
				tMap[i] = map[i].clone(); // deepcopy

			}
			for (int i = 0; i < N; i++) { // 행 길이만큼 실행 -> 무조건 게임이 끝남
				killCnt += shoot();
				move_minion();
			}
			maxDeathCnt = Math.max(maxDeathCnt, killCnt);
			return;
		}

		// 뽑아야지
		if (selectIdx >= M) {
			return;
		}

		// 여기까지 왔으면 더 뽑을 게 있다.

		selectedArcher[selectIdx] = true;
		comb(selectIdx + 1, selectCnt + 1);
		selectedArcher[selectIdx] = false;
		comb(selectIdx + 1, selectCnt);
	}

	static boolean[][] visited = new boolean[N][M];

	static int shoot() {
		int[][] target = new int[3][2]; // 각 궁수별로 활을 쏠 위치
		int idx = 0;
		int tIdx = 0;
		for (int i = 0; i < M; i++) {
			if (selectedArcher[i]) { // 궁수의 위치
				visited = new boolean[N][M]; // 궁수마다 따로 봐줘야함
				target[idx++] = bfs(i); // {-1,-1}이 들어올 수도 있음
			}
		}

		int killCnt = 0;
//		Set<int[]> set = new HashSet<>();
//		set.add()
		for (int i = 0; i < 3; i++) {
			if (!(target[i][0] == -1 && target[i][1] == -1)) {
				// tMap에서 제거해야지
				if (tMap[target[i][0]][target[i][1]] == 1) {
					tMap[target[i][0]][target[i][1]] = 0;
					killCnt += 1;
				}
//				set.add(target[i]); // 중복 제거
			}
		}
//		for (int i = 0; i < 3; i++) {
//			for (int j = i + 1; j < 3; j++) {
//				if (i != j && (target[i][0] != target[j][0] || target[i][1] != target[j][1])) {
//					tIdx++;
//				}
//			}
//		}

//		killCnt += set.size();

		return killCnt;
	}

	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 }; // 왼 위 좌
//	static int cnt = 1;

	static class Node {
		int x, y, cnt;

		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int[] bfs(int archerPositionY) {
		int root_y = archerPositionY;
		int root_x = N - 1; // 제일 아래 위치

		Queue<Node> queue = new ArrayDeque<>();
		int cnt = 1;

		queue.offer(new Node(root_x, root_y, cnt));
		visited[root_x][root_y] = true;
		while (!queue.isEmpty()) {
			Node tNode = queue.poll();
			cnt = tNode.cnt; // 업데이트
			if (cnt > D)
				return (new int[] { -1, -1 }); // 잡을 수 있는 애 없어
			if (tMap[tNode.x][tNode.y] == 1) { // 찾는 그 녀석
				return (new int[] { tNode.x, tNode.y });
			}

			for (int i = 0; i < 3; i++) {
				int nx = tNode.x + dx[i];
				int ny = tNode.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) { // 범위 안에 있으면
					queue.offer(new Node(nx, ny, cnt + 1));
					visited[nx][ny] = true;
				}
			}
		}
		return (new int[] { -1, -1 }); // 여기까지 오는게 말이 안되긴해

	}

	static void move_minion() { // map을 deepcopy해서 가져와야할듯
		for (int i = N - 1; i >= 1; i--) { // 아래에서 위로 확인하면서 덮어씌울 예정
			for (int j = 0; j < M; j++) {
				tMap[i][j] = tMap[i - 1][j];
			}
		}
		// 마지막줄은 다 0으로 밀어
		for (int i = 0; i < M; i++) {
			tMap[0][i] = 0;
		}
	}
}
