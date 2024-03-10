package gus0_0th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20922_겹치는건싫어 {
    static int N,K;
    static int[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        simulation();

    }

    static void simulation(){
        int result = 0;

        int[] cnt = new int[100010];
        int l = 0;
        for (int r = 0; r < N ; r++) {
            int num = map[r];

            cnt[num] ++;
            if(cnt[num] > K){
                for (int i = l; i < r; i++) {
                    cnt[map[i]]--;
                    if(map[i] == num){
                        l = i + 1;
                        break;
                    }
                }
            }
            result = Math.max(result, r - l + 1);
        }

        System.out.println(result);
    }
}
