import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, time, jihoon[] = new int[2];// 세로,가로,걸린 시간,지훈이의 위치
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static Queue<int[]> fire = new ArrayDeque<>();// 불의 좌표 큐

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		} // map입력

		find();
		bfs();
	}

	static void find() {// 지훈이와 불의 초기 위치 좌표 확인
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					jihoon[0] = i;
					jihoon[1] = j;
				} else if (map[i][j] == 'F') {
					fire.add(new int[] { i, j });
				}
			}
		}
	}

	static void bfs() {
		if (jihoon[0] == 0 || jihoon[0] == R - 1 || jihoon[1] == 0 || jihoon[1] == C - 1) {// 처음부터 가장자리에 도착한 경우
			System.out.println(time + 1);// 가장자리에서 나가는데 필요한 시간+1
			return;
		}
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(jihoon);
		while (!queue.isEmpty()) {
			extend();// 불을 먼저 확산시킨 후 지훈이가 이동할 수 있는지 확인
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = cur[0] + dr[dir];
					int nc = cur[1] + dc[dir];
					if (cango(nr, nc) && map[nr][nc] == '.') {
						if (nr == 0 || nr == R - 1 || nc == 0 || nc == C - 1) {// 가장자리에 도착한 경우
							System.out.println(time + 2);// 이동하고 시간을 안 더해줬으니 +1 ,가장자리에서 나가는데 필요한 시간+1
							return;
						}
						queue.add(new int[] { nr, nc });
						map[nr][nc] = 'v';// 지훈이의 방문처리
					}
				}
			}
			time++;
		}
		System.out.println("IMPOSSIBLE");// 도착하지 못했는데 bfs탐색이 끝난 경우
	}

	static void extend() {// 불의 확산
		int size = fire.size();
		for (int i = 0; i < size; i++) {
			int[] cur = fire.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur[0] + dr[dir];
				int nc = cur[1] + dc[dir];
				if (cango(nr, nc) && map[nr][nc] != '#' && map[nr][nc] != 'F') {
					map[nr][nc] = 'F';
					fire.add(new int[] { nr, nc });
				}
			}

		}

	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C)
			return true;
		return false;
	}
}
