import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, ans;
	static int[][] mat;
	static int[][] orin;//입력으로 받은 인접 행렬을 유지하면서 플로이드 적용 전의 원본 행렬을 만들기 위해

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		orin = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				orin[i][j] = mat[i][j];
			}
		} // 인접 행렬 입력

		r_floyd();

	}

	static void r_floyd() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j && i != k && k != j) {
						if (mat[i][j] == mat[i][k] + mat[k][j])
							orin[i][j] = 0;//다른 경로를 거치면서 그 경로를 최소로 갈 수 있다면
						if (mat[i][j] > mat[i][k] + mat[k][j]) {
							System.out.println(-1);
							return;//다른 경로를 거쳐서 가는 게 최소로 설정된 지금보다 더 작다면
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += orin[i][j];
			}
		}
		System.out.println(ans / 2);//양방향이므로 2를 나눠 1번만 더해줌

	}

}