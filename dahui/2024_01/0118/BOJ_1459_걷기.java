package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1459_걷기 {
    static long X,Y;
    static int W,S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        long ans1 = 0;
        long ans2 = 0;
        long ans3 = 0;
        
        ans1 = (X+Y)*W;
        ans2 = Math.min(X,Y) * S + Math.abs(X-Y) * W;
        
        if((X+Y)%2==0) {
        	ans3 = Math.max(X, Y) * S;
        }else {
        	ans3 = (Math.max(X, Y)-1) * S + W;
        }


        System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
    }
}
