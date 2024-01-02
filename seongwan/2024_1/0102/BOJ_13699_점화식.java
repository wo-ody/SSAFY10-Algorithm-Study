import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static long[] dp;
    public static void main(String[] args)throws Exception {
   N=Integer.parseInt(br.readLine());
        dp= new long[N+1];
        dp[0]=1;
        for (int i = 1; i <=N ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[N]);
    }
}