import java.util.*;
import java.io.*;
public class Main {
	static int[][][] dp;
	static int modifier = 1_000_000_000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1][10][(1<<10)];
		
		int res = 0;
		for (int j=1; j<10; j++){
		    res += f(n, j, (1<<10)-1);
		    res %= modifier;
		}
		System.out.println(res);
	}
	
	public static int f(int i, int j, int k) {
		if (k==0 && i!=0) return 0;
		if (i==0) {
			if (k==0)return 1;
			return 0;
		}
		if (dp[i][j][k] != 0) return dp[i][j][k];
		int res=0, next;
		if (j>0) {
			res += f(i-1, j-1, k);
			res%=modifier;
			next = k&~(1<<j);
			if (k!=next) {
				res += f(i-1, j-1, next);
				res%=modifier;
			}
		}
		if (j<9) {
			res += f(i-1, j+1, k);
			res%=modifier;
			next = k&~(1<<j);
			if (k!=next) {
				res += f(i-1, j+1,next);	
				res%=modifier;
			}
		}
		return dp[i][j][k] = res;
	}
}
