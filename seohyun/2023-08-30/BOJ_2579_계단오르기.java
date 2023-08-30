import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2579_계단오르기 {
	static int N;
	static int[] step;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		step = new int[N];
		
		for (int i = 0; i < N; i++) step[i] = Integer.parseInt(br.readLine());
		
		System.out.println(simulation());
	}
	
	static int simulation() {
		int[][] memo = new int[2][N];
		
		if(N == 1) return step[0];
		
		memo[0][0] = step[0];
		memo[0][1] = step[1];
		
		for (int i = 0; i < N; i++) {
			if(i + 1 < N ) {
				memo[1][i+1] = Math.max(memo[1][i+1], memo[0][i] + step[i+1]);
			}
			if(i + 2 < N ) {
				memo[0][i+2] = Math.max(memo[0][i+2], memo[0][i] + step[i+2]);
			}
			if(i + 2 < N ) {
				memo[0][i+2] = Math.max(memo[0][i+2], memo[1][i] + step[i+2]);
			}
		}
		
		return Math.max(memo[0][N-1], memo[1][N-1]);
	}

}
