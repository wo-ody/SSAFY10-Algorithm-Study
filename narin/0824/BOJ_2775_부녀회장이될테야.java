import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] apt = new int[15][15];

		for (int i = 0; i < 15; i++) {
			apt[0][i] = i;
			apt[i][1] = 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			System.out.println(apt[k][n]);
		}
	}
}
