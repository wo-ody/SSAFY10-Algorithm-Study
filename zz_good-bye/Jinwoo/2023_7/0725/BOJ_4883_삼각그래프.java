import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while (true) {
			int n = sc.nextInt();
			if (n==0) break;
			int[][] G = new int[n][3];
			int[][] dp = new int[n][3];
			for (int i=0;i<n;i++) {
				for (int j=0;j<3;j++) {
					G[i][j] = sc.nextInt();
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i=0;i<3;i++) dp[1][i] = G[1][i]+G[0][1];
			dp[0][2] = G[0][1]+G[0][2];
			dp[1][1] = Integer.min(dp[0][2]+G[1][1], dp[1][1]);
			dp[1][2] = Integer.min(dp[0][2]+G[1][2], dp[1][2]);
			for (int i=1;i<n-1;i++) {
				for (int j=0;j<3;j++) {
					if (j+1<=2) dp[i][j+1] = Integer.min(dp[i][j]+G[i][j+1], dp[i][j+1]);
					for (int k=-1;k<=1;k++) {
						if (0<= j+k && j+k <3) dp[i+1][j+k] = Integer.min(G[i+1][j+k]+dp[i][j], dp[i+1][j+k]);
					}
				}
			}
			dp[n-1][1] = Integer.min(dp[n-1][0]+G[n-1][1], dp[n-1][1]);
			System.out.println(String.format("%d. %d", t, dp[n-1][1]));
			t++;
		}
		sc.close();
	}
}
