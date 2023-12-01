import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, ans;
	static StringTokenizer st;
	static int[][] priority;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		priority = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				priority[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				for (int k = j + 1; k < M; k++) {
					int sum = 0;
					for (int l = 0; l < N; l++) {
						int temp = 0;
						temp = Math.max(priority[l][i], priority[l][j]);
						temp = Math.max(temp, priority[l][k]);
						sum += temp;
					}
					ans = Math.max(ans, sum);
				}
			}
		}
		System.out.println(ans);
	}
}