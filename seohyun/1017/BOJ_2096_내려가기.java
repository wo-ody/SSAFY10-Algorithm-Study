import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][3];
		int[][] dp2 = new int[N][3];
		
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		dp2[0][0] = map[0][0];
		dp2[0][1] = map[0][1];
		dp2[0][2] = map[0][2];
		
		for (int i = 0; i < N - 1; i++) {
			dp[i+1][0] = Math.max(dp[i][0], dp[i][1]) + map[i+1][0];
			
			dp[i+1][1] = Math.max(Math.max(dp[i][0], dp[i][1]) , dp[i][2]) + map[i+1][1] ;
		
			dp[i+1][2] = Math.max(dp[i][1], dp[i][2]) + map[i+1][2];
		}
		
		for (int i = 0; i < N - 1; i++) {
			dp2[i+1][0] = Math.min(dp2[i][0], dp2[i][1]) + map[i+1][0];
			
			dp2[i+1][1] = Math.min(Math.min(dp2[i][0], dp2[i][1]) , dp2[i][2]) + map[i+1][1] ;
		
			dp2[i+1][2] = Math.min(dp2[i][1], dp2[i][2]) + map[i+1][2];
		}
		
		int rMax = Math.max(Math.max(dp[N-1][0], dp[N-1][1]) , dp[N-1][2]);
		int rMin = Math.min(Math.min(dp2[N-1][0], dp2[N-1][1]) , dp2[N-1][2]);

		System.out.println(rMax + " " + rMin);
	}

}
