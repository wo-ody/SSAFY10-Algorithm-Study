import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, map[][], time;// 세로,가로,맵,걸린 시간
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean flag = true;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 입력

		simul();
		System.out.println(time);

	}

	static void outair() {// 외부 공기 찾기(0,0에서 시작해서 bfs로 탐색 가능한 치즈가 아닌 곳은 외부 공기)
		// 외부 공기는 2, 내부 공기는 0 그대로
		// 1년 후 내부 공기가 외부 공기가 될 수 있으므로 0,2 다 탐색 후 0,0과 이어지면 외부 공기로 처리
		boolean[][] visit = new boolean[N][M];// 방문 처리
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0 });
		map[0][0] = 2;
		visit[0][0] = true;
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc) && (map[nr][nc] == 0 || map[nr][nc] == 2) && !visit[nr][nc]) {
					queue.add(new int[] { nr, nc });
					map[nr][nc] = 2;// 외부 공기로 처리
					visit[nr][nc] = true;
				}
			}
		}

	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		return false;
	}

	static void after() {
		flag = false;// 1이 하나라도 탐색되면 true로 바꾸고 계속 시뮬레이션 진행
		for (int i = 1; i < N - 1; i++) {// 가장자리는 외부공기이므로 치즈 탐색 시 제외
			for (int j = 1; j < M - 1; j++) {
				if (map[i][j] == 1) {
					flag = true;
					int cnt = 0;// 주변 외부 공기의 수
					for (int dir = 0; dir < 4; dir++) {
						if (cnt == 2)
							break;// 2변 이상이 외부 공기이므로 더 이상 탐색 필요x
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						if (cango(nr, nc) && map[nr][nc] == 2)
							cnt++;
					} // 주변 외부공기 개수 파악
					if (cnt == 2)
						map[i][j] = 0;
					// 없어진 치즈를 내부 공기인 0으로 교체해 다음 치즈의 녹음에 영향을 주지 않게 함
				}
			}
		}
	}

	static void simul() {
		// 처음 외부 공기와 내부 공기 구별
		outair();
		while (true) {
			after();// 외부공기와 2변 이상 접촉된 치즈들 삭제
			if (!flag)// 치즈가 없어서 시뮬레이션이 진행되지 않았다면
				return;
			time++;// 정상적으로 진행되었다면 1년 추가
			outair();// 외부공기와 내부공기 구별
		}

	}

//	static void print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
