import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나도...퇴사...는 못하고...쉬고 싶어...!!!
public class Main {
	static int N;
	static Counsel[] counsels;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		counsels = new Counsel[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			counsels[i] = new Counsel(T, P);
		}
		
		dp = new int[N+1];
		for(int i=0; i<N; i++){
			if(i + counsels[i].T <= N) {
				int day = i + counsels[i].T;
				dp[day] = Math.max(dp[day], dp[i]+counsels[i].P);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[N]);
	}
	
	static class Counsel{
		int T, P;
		Counsel(int T, int P){
			this.T = T;
			this.P = P;
		}
	}
}
