package algorithm2024.jan.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18427_함께블록쌓기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        //각 블록의 수가 다르므로 arraylist로 저장
        List<ArrayList<Integer>> block = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            block.add(new ArrayList<>());
            //아예 안 넣는 경우를 위해 0을 추가
            block.get(i).add(0);
            //해당하는 사람의 모든 블록 저장
            while (st.hasMoreTokens()) {
                block.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[N][H+1];
        //첫번째 사람은 자신의 블록에 대한 경우만 생각하면 되므로 바로 저장
        for (Integer i : block.get(0)) {
            if(i<=H){
                dp[0][i]++;
            }
        }
        //다음 사람부터
        for (int i = 1; i < N; i++) {
            //가지고 있는 각각의 블록에 대해
            for (int j = 0; j < block.get(i).size(); j++) {
                //더했을 때 H를 넘지 않는다면 경우의 수 계산하여 저장
                for (int k = 0; k <= H; k++) {
                    if (dp[i - 1][k] > 0) {
                        if (block.get(i).get(j) + k <= H) {
                            dp[i][block.get(i).get(j) + k] = (dp[i][block.get(i).get(j) + k] + dp[i - 1][k]) % 10007;
                        }
                    }
                }
            }
        }
        System.out.println(dp[N-1][H]);

    }
}
