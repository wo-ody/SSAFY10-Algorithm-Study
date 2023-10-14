import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int mat[][];
	static int INF = 1000000;
	static int T, N, M, K, min, ans;
	static int[] friends;// 참석하는 친구 번호

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			min = INF;// min값 테스트케이스별 초기화
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			mat = new int[N + 1][N + 1];// 0은 더미
			for (int i = 1; i <= N; i++) {
				Arrays.fill(mat[i], INF);
			} // 인접행렬 INF로 초기화

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				mat[from][to] = w;
				mat[to][from] = w;
			} // 인접행렬 입력

			K = Integer.parseInt(br.readLine());
			friends = new int[K];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			} // 참석하는 친구 번호 입력

			floyd();
			find();
		}
		System.out.println(sb);

	}

	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}

	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 0; j < K; j++) {
				if (i != friends[j])
					temp += mat[i][friends[j]];
			}
			if (temp < min) {
				min = temp;
				ans = i;
			}
		}
		sb.append(ans + "\n");
	}//참석하는 친구들의 모든 방 까지의 최소 거리를 더하고 그 합의 최소를 구함
}