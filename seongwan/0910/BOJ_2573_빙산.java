import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, map[][], map_c[][], year; // 녹는 과정 중 원본 맵 유지 위한 복사맵
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean flag; // 끝까지 분할되지 못할 때

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		map_c = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // map 입력
		for (int i = 0; i < N; i++) {
			map_c[i] = Arrays.copyOf(map[i], M);
		}
		while (true) {
			if (!find())
				break;
			year++;
			afteryear();
		}
		System.out.println(flag ? 0 : year);

	}

	static boolean find() {
		int cnt = 0;// 분할된 빙산 영역의 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map_c[i][j] > 0) {
					cnt++;
					if (cnt > 1)
						return false;
					bfs(i, j);

				}
			}
		}
		if (cnt == 0) {
			flag = true;
			return false;
		}
		return true;
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		map_c[r][c] = 0;// 방문 체크
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (map_c[nr][nc] > 0) {
					queue.add(new int[] { nr, nc });
					map_c[nr][nc] = 0;
				}
			}
		}
	}

	static void afteryear() {
		for (int i = 0; i < N; i++) {
			map_c[i] = Arrays.copyOf(map[i], M);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					int seacount = 0;// 인접 바다의 개수
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						if (map[nr][nc] == 0)
							seacount++;
					}
					map_c[i][j] = map_c[i][j] - seacount < 0 ? 0 : map_c[i][j] - seacount;
					// 인접 바다 수 만큼 감소했을 때 0밑이라면 0으로 고정
				}
			}
		}
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(map_c[i], M);
		} // 과정이 다 지난 후 원본 맵에 복사맵 복사
	}

}
