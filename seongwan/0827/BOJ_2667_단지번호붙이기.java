import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, count, num;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };// 4방향 탐색(반시계방향)
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		} // map 입력
		find();
		sb.append(count + "\n");
		for (int i = 0; i < count; i++) {
			sb.append(pq.poll() + "\n");
		}
		System.out.println(sb);

	}

	static void find() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					num = 0;
					count++;
					dfs(i, j);
					pq.add(num);
				}
			}

		}
	}

	static void dfs(int r, int c) {
		map[r][c] = 2;// 방문체크
		num++;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (gocan(nr, nc))
				dfs(nr, nc);
		}
	}

	static boolean gocan(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 1)
			return true;
		else
			return false;
	}
}
