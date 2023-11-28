import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static int[][] mat;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		mat = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = i + 1; j < N; j++) {
				if (s.charAt(j) == 'Y') {
					mat[i][j] = 1;
					mat[j][i] = 1;
				}
			}
		}

		floyd();
		find();
	}

	static void floyd() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (mat[i][k] == 1 && mat[k][j] == 1 && mat[i][j] != 1)
						mat[i][j] = 2;
				}
			}
		}
	}

	static void find() {
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				if (mat[i][j] >= 1)
					temp++;
//				System.out.print(mat[i][j] + " ");
			}
//			System.out.println();
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
	}
}