import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, maxidx, ans;
	static int[] pack;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		pack = new int[N + 1];
		dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		} // 카드팩 가격 입력

		dp[1] = pack[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = pack[i];
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
			}
		}
		System.out.println(dp[N]);
	}
}