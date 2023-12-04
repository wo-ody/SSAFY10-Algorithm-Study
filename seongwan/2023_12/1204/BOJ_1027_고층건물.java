import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans, y, x;
	static int[] building;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		building = new int[N + 1]; // 0은 더미
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				boolean chk = true;
				for (int k = Math.min(i, j) + 1; k < Math.max(i, j); k++) {
					double fuc = ((double) (building[j] - building[i]) / (double) (j - i)) * (k - i) + building[i];
					if (building[k] >= fuc) {
						chk = false;
						break;
					}
				}
				if (chk)
					count++;
			}
			ans = Math.max(ans, count);
		}
		System.out.println(ans);
	}
}
