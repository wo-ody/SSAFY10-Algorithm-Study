import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static BigInteger[] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new BigInteger[N + 1];
        if (N >= 0)
            dp[0] = BigInteger.ZERO;
        if (N >= 1)
            dp[1] = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.println(dp[N]);
    }
}