package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간_합_구하기_4 {
    static int[] numbers;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        numbers = new int[number];
        dp = new int[number];
        st = new StringTokenizer(br.readLine());

        for(int n = 0; n < number; n++) numbers[n] = Integer.parseInt(st.nextToken());
        dp[0] = numbers[0];

        for(int i = 1; i < number; i++) dp[i] = dp[i-1] + numbers[i];

        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(make(a-1, b-1));
        }

    }

    static int make(int a, int b){
        if(a == 0) return dp[b];
        else if (a == b) return numbers[b];
        else return dp[b] - dp[a-1];
    }

    static void printArrays(int[] arr1, int[] arr2){
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
