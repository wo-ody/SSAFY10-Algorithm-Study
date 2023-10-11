package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_15989_123더하기4 {
    static int T;
    static int[][] memo = new int[10001][4];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        simulation();
        for (int tc = 1; tc <= T ; tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(memo[N][1] + memo[N][2] + memo[N][3]);
        }

    }

    static void simulation(){
        memo[1][1] = 1;
        memo[2][1] = 1;
        memo[2][2] = 1;
        memo[3][1] = 1;
        memo[3][2] = 1;
        memo[3][3] = 1;

        for (int i = 4; i < 10001; i++) {
            memo[i][1] = memo[i-1][1];
            memo[i][2] = memo[i-2][1] + memo[i-2][2];
            memo[i][3] = memo[i-3][1] + memo[i-3][2] + memo[i-3][3];
        }
    }
}
