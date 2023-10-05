import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        int[] pay = new int[N];
        int[] dp = new int[N+1];
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
      
        for(int i = 0; i< N; i++){ // 날짜를 0부터 시작(1부터 시작하면 마감 날짜 = 시작날짜 + 기간 -1 이 되므로 인덱스를 0부터 시작함)
            if(i + time[i] <= N) { // 마감 기한이 N이하인 경우(범위 안)
                // 마감기한까지 최대한 이익은 (현재 마감기한까지의 최대이익)과, (시작기간까지의 최대이익 + 현재 날짜에서 얻을 수있는 보상) 중 최대 값
                dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i] + pay[i]);
            }

            // 0으로 채워진 자리를 이전 dp로 채움;
            dp[i + 1] = Math.max(dp[i+1],dp[i]);

        }
        System.out.println(dp[N]);

    }
}
