package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] dp = new int[L+1];

        st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());
        for(int l = 2; l <= L; l++) dp[l] = Integer.parseInt(st.nextToken()) + dp[l-1];

        int start = 0;
        int end = 1;
        int min = Integer.MAX_VALUE;

        while(end <= L){
            if(dp[end] - dp[start] < D) end++;
            else{
                min = Math.min(min, end - start);
                start++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
