import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[][] map, result;
	static boolean[][] visit;// bfs 체크용
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static List<Integer> group = new ArrayList<>();// 0마다 bfs를 돌고 그룹별 개수 저장
	static Set<Integer> set = new HashSet<>();// 벽의 인접 그룹 체크용
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		} // 맵 입력

		find();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] % 10);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void find() {
		int gnum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visit[i][j])// 빈 칸마다의 인접 영역 저장
				{
					group.add(bfs(i, j, gnum));
					gnum++;

				} // 그룹 gnum의 개수는 group gnum-1번쨰 인덱스에 저장
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) { // 벽을 부쉈을 때 벽을 기준으로 인접 영역의 개수를 합을 구함
					set.clear();
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						if (cango(nr, nc))
							set.add(result[nr][nc]);
					}
					for (int num : set) {
						map[i][j] += group.get(num - 1);
					}
				}
			}
		}

	}

	static int bfs(int r, int c, int gnum) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		visit[r][c] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			result[cr][cc] = gnum;
			cnt++;
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
			}
		}
		return cnt;
	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0)
			return true;
		return false;
	}

}