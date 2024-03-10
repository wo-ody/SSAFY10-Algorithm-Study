package gus0_0th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2839_설탕배달 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());

        int result = -1;
        for (int cnt = N/5; cnt >= 0 ; cnt--) {
            int remain = N - (5*cnt);
            if(remain == 0){
                result = cnt;
                break;
            }
            else if(remain / 3 > 0 && remain % 3 == 0){
                result = cnt + (remain/3);
                break;
            }
        }

        System.out.println(result);

    }
}
