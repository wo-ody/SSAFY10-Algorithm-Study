import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int[] files = new int[K+1];
			int[][] dp = new int[K+1][K+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				files[i] = files[i-1] + Integer.parseInt(st.nextToken());
			}
			
			for(int n=1; n<=K; n++) {
				for(int from = 1; from + n <= K; from++) {
					int to = from + n;
					dp[from][to] = Integer.MAX_VALUE;
					for(int divide = from; divide < to; divide++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][divide]+dp[divide+1][to]+files[to]-files[from-1]);
					}
				}
			}
			System.out.println(dp[1][K]);
		}
	}
}
