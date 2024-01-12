import java.io.BufferedReader;
import java.io.InputStreamReader;

//i를 만들 수 있는 경우는
//i-3,i-2,i-1의 경우에서 각각 3,2,1을 더하는 경우
//따라서 dp[i-3]~[i-1]을 더한 값이 dp[i]
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static long[] dp = new long[1000001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        //dp배열 만들기
        init();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num] + "\n");
        }

        System.out.println(sb);
    }

    static void init() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
        }
    }
}