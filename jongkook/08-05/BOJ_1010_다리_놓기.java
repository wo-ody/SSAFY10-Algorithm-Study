package baekjoon;
import java.util.*;
import java.io.*;

public class BOJ_1010_다리_놓기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[30][30];

		for(int i = 0; i < 30; i++) dp[0][i] = i+1;

		for(int i = 1; i < 30; i++) for(int j = i; j < 30; j++) dp[i][j] = dp[i-1][j-1] + dp[i][j-1];


		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken())-1;
			int after = Integer.parseInt(st.nextToken())-1;
			System.out.println(dp[before][after]);
		}
	}
}
