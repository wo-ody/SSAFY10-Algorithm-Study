package boj;

import java.io.*;
import java.util.*;

public class boj_21921_블로그 {
    static int N,X;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        simulation();
    }

    static void simulation(){
        long sum = 0;
        int cnt = 1;

        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        long max_sum = sum;
        for (int i = X; i < N; i++) {
            sum += (arr[i] - arr[i-X]);

            if(sum > max_sum){
                max_sum = sum;
                cnt = 1;
            }
            else if(sum == max_sum) cnt++;
        }

        if(sum == 0) {
            System.out.println("SAD");
        }
        else{
            System.out.println(max_sum);
            System.out.println(cnt);
        }
    }
}
