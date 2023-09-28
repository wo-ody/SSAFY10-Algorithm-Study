import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static StringTokenizer st;
	static int[][] mat;
	static int INF = 10000000;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		mat = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(mat[i], INF);
		} // 인접 행렬 INF로 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			mat[from][to] = 1;
		} // 인접 행렬 입력

		floyd();
		find();
		System.out.println(sb);

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
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] == 1 || mat[j][i] == 1)
					cnt++;//무게 비교가 가능한 물건 수 계산
			}
			sb.append(N - 1 - cnt + "\n");//본인 제외 물건 수에서 무게 비교 가능한 물건 수를 제외
		}
	}

}
