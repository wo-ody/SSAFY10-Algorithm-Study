import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, capacity, answer;
	static int[] trains;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		trains = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			trains[i] = Integer.parseInt(st.nextToken()) + trains[i-1];
		}
		
		capacity = Integer.parseInt(br.readLine());
		
		dp = new int[4][N+1];
		for(int i=1; i<4; i++) {
			for(int j=i*capacity; j<=N; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-capacity]+(trains[j]-trains[j-capacity]));
			}
		}
		System.out.println(dp[3][N]);
	}
}
