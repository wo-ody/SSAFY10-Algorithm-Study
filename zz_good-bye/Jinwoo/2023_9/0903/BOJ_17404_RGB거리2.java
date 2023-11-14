import java.io.*;
import java.util.*;
public class Main{
    public static void main (String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] hCost = new int[n][3];
        StringTokenizer st;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                hCost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, dp(0, hCost, n));
        ans = Math.min(ans, dp(1, hCost, n));
        ans = Math.min(ans, dp(2, hCost, n));
        System.out.println(ans);
    }

    static int dp(int last, int[][] hCost, int n) {
        int[][] dp = new int[n][3];
        dp[0] = hCost[0].clone();
        dp[0][last] = Integer.MAX_VALUE;
        int a,b;
        for (int i=1; i<n; i++) {
            for (int j=0; j<3; j++){
                a = dp[i-1][(j+1)%3]; b= dp[i-1][(j+2)%3];
                dp[i][j] = Math.min(a,b) + hCost[i][j];
            }
        }
        return dp[n-1][last];
    }
}
