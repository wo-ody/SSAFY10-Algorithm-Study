import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static int[][] mat;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			mat[from][to] = 1;
		} // 간선 정보 입력

		floyd();
		find();
		System.out.println(ans);

	}

	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (mat[i][k] == 1 && mat[k][j] == 1)
						mat[i][j] = 1;
				}

			}

		}
	}// 플로이드-워셜

	static void find() {
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] == 1 || mat[j][i] == 1)
					cnt++;
			} // i에서 들어오거나 나갈 수 있는 정점의 수를 체크
			if (cnt == N - 1)
				ans++;// 자기 자신 제외 다 갈 수 있다면 +1

		}

	}
}
