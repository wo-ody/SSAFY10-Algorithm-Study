import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] arr;
	static boolean[][] visit;
	static int N, maxRain, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxRain = Math.max(maxRain, arr[i][j]);
			}
		}

		for (int i = 0; i < maxRain; i++) {
			simul(i);
		}
		System.out.println(ans);
	}

	static void simul(int rain){
		visit = new boolean[N][N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					Queue<int[]> q = new ArrayDeque<>();

					if (arr[i][j] <= rain) {
						visit[i][j] = true;
						continue;
					}
					cnt++;
					q.add(new int[]{i,j});
					visit[i][j] = true;

					while(!q.isEmpty()) {
						int[] node = q.poll();
						int y = node[0];
						int x = node[1];

						for (int k = 0; k < 4; k++) {
							int ny = y + dy[k];
							int nx = x + dx[k];

							if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] ) continue;

							visit[ny][nx] = true;
							if (arr[ny][nx] <= rain) continue;
							q.add(new int[]{ny,nx});
						}
					}
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
}
