import java.util.*;
import java.io.*;

public class BOJ_10942_펠린드롬 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	static int[][] dp;
	static int[] arr;
	
	public static void main(String[] arg) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[n][n];
		for (int len=0; len<n; len++) {
			for (int i=0; i+len<n;i++) {
				 ispalin(i,i+len);
			}
		}
		int m = Integer.parseInt(bf.readLine());
		int s, e;
		for (int i=0; i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			bw.write(dp[s-1][e-1]+"\n");
		}
		bw.flush();
		bw.close();
		
	} // main
	
	public static void ispalin(int i, int j) {
		if (i==j) dp[i][j]=1;
		else if ((i==j-1) && (arr[i] == arr[j])) dp[i][j]= 1;
		else if ((arr[i] == arr[j]) && dp[i+1][j-1]==1) dp[i][j]= 1;
		else dp[i][j]=0;
	}
}
