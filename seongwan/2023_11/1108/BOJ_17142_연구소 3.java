import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans = -1;
	static List<int[]> virus = new ArrayList<int[]>();// 비활성 바이러스의 좌표
	static int[] tgt;
	static int[][] map;
	static int count;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tgt = new int[M];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				} else if (map[i][j] == 0)
					count++;
			}
		} // 맵을 입력받으면서 바이러스들의 좌표와 빈 칸의 개수를 구함
		if (count == 0)// 빈 칸이 처음부터 없는 경우
			System.out.println(0);
		else {
			comb(0, 0);
			System.out.println(ans);
		}
	}

	static void comb(int num, int tgtidx) {
		if (tgtidx == M) {
			bfs();
			return;
		}
		if (num == virus.size())
			return;
		tgt[tgtidx] = num;
		comb(num + 1, tgtidx + 1);
		comb(num + 1, tgtidx);

	}

	static void bfs() {
		int temp = 0, depth = 0;
		visit = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			queue.add(virus.get(tgt[i]));
			visit[virus.get(tgt[i])[0]][virus.get(tgt[i])[1]] = true;// 방문 처리
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (cango(nr, nc)) {
						if (map[nr][nc] == 0) {
							temp++;// 빈 칸이면 개수를 체크
							if (temp == count) {// 모든 빈 칸을 채웠을 때
								if (ans != -1)// 그 전에 바이러스가 다 퍼진 경우가 있었다면 최소를 답으로 갱신
									ans = Math.min(ans, depth + 1);
								else
									ans = depth + 1;// 바이러스가 처음 다 퍼진 경우면 depth+1를 답으로 갱신
								return;
							}
							visit[nr][nc] = true;
							queue.add(new int[] { nr, nc });
						} else if (map[nr][nc] == 2) {
							visit[nr][nc] = true;
							queue.add(new int[] { nr, nc });
						}
					}
				}
			}
			depth++;
		}
	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc])
			return true;
		return false;
	}
}