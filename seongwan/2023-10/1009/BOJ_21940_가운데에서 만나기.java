import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, friend[];
	static int[][] mat;
	static int[][] result;
	static int INF = 10000000;
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N + 1][N + 1]; // 0은 더미
		result = new int[N + 1][N + 1]; // 0은 더미
		for (int i = 1; i <= N; i++) {
			Arrays.fill(mat[i], INF);
		} // INF로 mat 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			mat[from][to] = w;
		} // 인접행렬 입력

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		friend = new int[K];
		for (int i = 0; i < K; i++) {
			friend[i] = Integer.parseInt(st.nextToken());
		} // 친구들이 살고 있는 도시 번호 입력

		floyd();
		find();
//		pirnt();
		System.out.println(ans);

	}

	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						mat[i][j] = 0;
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}

	}

//	static void pirnt() {
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				result[j][i] = result[i][j] = mat[i][j] + mat[j][i];// 왕복 시간
			}
		}
		int max = INF;
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 0; j < K; j++) {
				temp = Math.max(temp, result[i][friend[j]]);
			}
			if (temp < max) {// 왕복 시간의 최대가 더 최소인 경우가 있다면
				max = temp;
				ans.setLength(0);// 정답 초기화
				ans.append(i + " ");// 정답에 i추가
			} else if (temp == max) {
				ans.append(i + " ");
			}
		}
	}

}