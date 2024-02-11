package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047_동전0 {
    static int N,K;
    static int[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N];
        for (int i = N-1; i >=0 ; i--) {
            st = new StringTokenizer(br.readLine());
            map[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if(K / map[i] != 0){
                cnt += K / map[i];
                K %= map[i];
            }
        }

        System.out.println(cnt);
    }
}
