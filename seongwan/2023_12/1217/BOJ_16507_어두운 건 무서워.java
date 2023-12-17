import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, Q;
	static StringTokenizer st;
	static int[][] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		input = new int[R + 1][C + 1];
		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < C + 1; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sum();

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			int total = input[r2][c2] - input[r2][c1] - input[r1][c2] + input[r1][c1];
			int count = (r2 - r1) * (c2 - c1);
			sb.append(total / count + "\n");
		}
		System.out.println(sb);
	}

	static void sum() {
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				input[i][j] = input[i][j] + input[i - 1][j] + input[i][j - 1] - input[i - 1][j - 1];
			}
		}
	}
}