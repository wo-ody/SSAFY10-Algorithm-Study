import java.util.*;
import java.io.*;
 
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
 
        // dp[시간][이동횟수]
        int[][] dp = new int[t+1][w+1];
 
        for(int i=1; i<=t; i++) {
            int tree = Integer.parseInt(br.readLine());
 
            for(int j=0; j<=w; j++) {
                // 움직임 x
                // 나무 1에 떨어지면 1 추가
                if(j == 0) {
                    if(tree == 1) 
                        dp[i][j] = dp[i-1][j] + 1;
                    else            
                        dp[i][j] = dp[i-1][j];
 
                    continue;    //다음 시뮬 진행
                }
 
                // 짝수
                if(j%2 == 0) {
                    if(tree == 1) 
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else 
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                }
                
                // 홀수
                else {
                    if(tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }
 
        int ans = 0;
        for(int i=0; i<=w; i++)
            ans = Math.max(ans, dp[t][i]);
 
        System.out.println(ans);
    }
 
}
