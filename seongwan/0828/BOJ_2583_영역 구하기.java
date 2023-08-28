import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int M, N, K, count, num;
	static int[][] map;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			setsquare(sc, sr, ec, er);
		} // 맵에 사각형 두기
		find();
		sb.append(count + "\n");
		for (int i = 0; i < count; i++) {
			sb.append(pq.poll() + " ");
		}
		System.out.println(sb);
	}

	static void setsquare(int sc, int sr, int ec, int er) {

		for (int i = 0; i < er - sr; i++) {
			for (int j = 0; j < ec - sc; j++) {
				map[M - (1 + sr + i)][sc + j] = 1;
			}
		}
	}

	static void find() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					count++;
					num = 0;
					dfs(i, j);
					pq.add(num);
				}

			}

		}
	}

	static void dfs(int r, int c) {
		num++;
		map[r][c] = 1;// 방문 체크
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (gocan(nr, nc)) {
				dfs(nr, nc);
			}
		}
	}

	static boolean gocan(int r, int c) {
		if (r >= 0 && r < M && c >= 0 && c < N && map[r][c] == 0)
			return true;
		else
			return false;
	}
}
