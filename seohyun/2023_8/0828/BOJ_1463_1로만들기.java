package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1463_1로만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] memo = new int[X+1];
        for (int i = 0; i < X+1; i++) memo[i] = Integer.MAX_VALUE;

        memo[1] = 0;
        for (int i = 1; i < X + 1; i++) {
            if(i + 1 <= X) memo[i + 1] = Math.min(memo[i+1] , memo[i] + 1);
            if(i * 2 <= X) memo[i * 2] = Math.min(memo[i*2] , memo[i] + 1);
            if(i * 3 <= X) memo[i * 3] = Math.min(memo[i*3] , memo[i] + 1);
        }

        System.out.println(memo[X]);
    }
}
