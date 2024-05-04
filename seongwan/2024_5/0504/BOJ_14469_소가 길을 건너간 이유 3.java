import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringTokenizer st;
	static int[][] cow;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		cow = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			cow[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}

		Arrays.sort(cow, (e1, e2) -> e1[0] - e2[0]);

		cow[0][0] += cow[0][1];

		for (int i = 1; i < N; i++) {
			if (cow[i][0] >= cow[i - 1][0])
				cow[i][0] += cow[i][1];
			else {
				cow[i][0] += cow[i][1] + cow[i - 1][0] - cow[i][0];
			}
		}

		System.out.println(cow[N - 1][0]);
	}
}