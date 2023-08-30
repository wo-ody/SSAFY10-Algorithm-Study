import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] big = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			big[i][0] = Integer.parseInt(st.nextToken());
			big[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[N];
		Arrays.fill(count, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (big[i][0] < big[j][0] && big[i][1] < big[j][1]) {
					count[i]++;
				}
			}
		}

		for (int c : count) {
			System.out.print(c + " ");
		}
	}
}
