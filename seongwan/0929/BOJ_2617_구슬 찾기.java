import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
		} // 인접 행렬 입력

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
	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			int cheap = 0;
			int weight = 0;
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] == 1)
					cheap++;// i보다 가벼운 구슬의 개수
				if (mat[j][i] == 1)
					weight++;// i보다 무거운 구슬의 개수
			}
			if (cheap > N / 2 || weight > N / 2)
				// 무겁거나 가벼운 구슬의 개수가 본인 제외 구슬의 반이 넘는 경우
				ans++;
		}
	}

}
