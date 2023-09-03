import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int[] port, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		port = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			port[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(port[j] < port[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		answer = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}
