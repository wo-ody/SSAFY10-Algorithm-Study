import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] height;
	private static int N, M;

	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (height[i][k] != 0 && height[k][j] != 0) {
						height[i][j] = 1;
					}
				}
			}
		}
	}

	private static boolean count(int num) {

		int s1 = 0, s2 = 0;
		for (int i = 1; i <= N; i++) {
			if (height[num][i] == 1)
				s1++;
			else if (height[i][num] == 1)
				s2++;
		}

		if (s1 + s2 == N - 1)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		height = new int[N + 1][N + 1];
		int result = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			height[a][b] = 1;
		}

		floyd();

		for (int i = 1; i <= N; i++) {
			if (count(i))
				result++;
		}

		System.out.println(result);
	}
}
