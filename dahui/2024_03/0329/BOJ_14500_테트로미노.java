import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int N,M,ans;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				mino(i,j,1, arr[i][j]);
				o(i, j, 1, arr[i][j]);
				visit[i][j] = false;
			}
		}

		System.out.println(ans);
	}

	public static void mino(int i, int j, int d, int s){
		if (d == 4) {
			ans = Math.max(ans, s);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int y = i + dy[k];
			int x = j + dx[k];

			if(y < 0 || x < 0 || y >= N || x >= M || visit[y][x]) continue;

			visit[y][x] = true;
			mino(y, x, d+1, s+arr[y][x]);
			visit[y][x] = false;
		}
	}

	public static void o(int i, int j, int d, int s) {
		if(d == 3) {
			ans = Math.max(ans, s);
			return;
		}

		if (d == 1) {
			for (int k = 0; k < 4; k++) {
				int y = i + dy[k];
				int x = j + dx[k];
				if(y < 0 || x < 0 || y >= N || x >= M || visit[y][x]) continue;
				visit[y][x] = true;
				o(y, x, d+1, s+arr[y][x]);
				visit[y][x] = false;
			}
		}

		if(d == 2) {
			for (int k = 0; k < 4; k++) {
				int y1 = i + dy[k];
				int x1 = j + dx[k];
				int y2 = i + dy[(k+1)%4];
				int x2 = j + dx[(k+1)%4];

				if (y1 < 0 || y2 < 0 || x1 < 0 || x2<0
					|| y1 >= N || y2 >= N || x1 >= M || x2 >= M
					|| visit[y1][x1] || visit[y2][x2]
				) continue;

				o(y1,x1,d+1, s + arr[y1][x1] + arr[y2][x2]);
			}
		}

	}
}
