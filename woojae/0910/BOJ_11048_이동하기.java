import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
//	static int n, m;
//	static int[][] map;
//	static int candy;
//	
//	public static void main(String[] args) throws IOException {  // 완탐하면 시간 초과 발생
//		st = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		map = new int[n][m];
//		for(int i = 0; i < n; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < m; j++)
//				map[i][j] = Integer.parseInt(st.nextToken());
//		}
//		candy = Integer.MIN_VALUE;
//		dfs(0, 0, 0);
//		System.out.println(candy);
//	}
//	
//	static void dfs(int r, int c, int current_candy) {
//		if(r == n - 1 && c == m - 1) {
//			current_candy += map[r][c];
//			candy = candy < current_candy ? current_candy : candy;
//			return;
//		}
//		if(0 <= r && r < n && 0 <= c && c < m) {
//			dfs(r + 1, c, current_candy + map[r][c]);
//			dfs(r, c + 1, current_candy + map[r][c]);
//			dfs(r + 1, c + 1, current_candy + map[r][c]);
//		}
//	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++)
				dp[i][j] = map[i][j] + Math.max(dp[i][j-1], dp[i-1][j]);  
		// 오른쪽 이동 + 아래 이동, 아래 이동 + 왼쪽 이동은 결과적으로 대각선 이동과 동일하지만 더 많은 칸을 밞았기에 단순 대각이동보다 많은 사탕 획득 가능
		// r + 1, c + 1만 고려하면 됨
		System.out.println(dp[n][m]);
	}
}