package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3282_01_knapsack {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            // 횟수
            int v = Integer.parseInt(st.nextToken());
            // 최대 부피
            int c = Integer.parseInt(st.nextToken());
            int[][] dp = new int[v+1][c+1];
            int[] volumes = new int[101];
            int[] values = new int[101];
            for(int i = 1; i <= v; i++){
                st = new StringTokenizer(br.readLine());
                volumes[i] = Integer.parseInt(st.nextToken());
                values[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= v; i++){
                for(int j = 0; j <= c; j++){
                    dp[i][j] = dp[i-1][j];
                    // 여기서 j는 부피를 의미
                    // i번 물건을 가방에 못 넣는 경우를 제외
                    // 이전 반복문에서 현재의 부피만큼의 크기를 뺀 위치의 값과 현재 가치를 더함
                    if(volumes[i] <= j) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-volumes[i]] + values[i]);
                }
            }
            sb.append("#").append(t).append(" ").append(dp[v][c]).append("\n");
        }
        System.out.println(sb);

    }
}
