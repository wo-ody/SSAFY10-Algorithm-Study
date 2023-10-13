package boj;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] not_possible;

    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        not_possible = new boolean[11];
        if(M != 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                not_possible[num] = true;
            }
        }

        if(N == 100) {
            System.out.println(0);
            return;
        }
        if(M == 10){
            System.out.println(Math.abs(N-100));
            return;
        }

        result = Math.abs(N-100); //
        simulation();
        System.out.println(result);

    }

    static boolean isPossible(int num){
        String str = Integer.toString(num);
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if(not_possible[digit]) return false;
        }
        return true;
    }

    static void simulation() {
        int low = N;
        int high = N;
        boolean isStop = false;
        while(true){

            if(isPossible(low)) {
                //System.out.println("11");
                result = Math.min(result, Integer.toString(low).length() + Math.abs(low - N));
                isStop = true;
            }
            if(isPossible(high)) {
                //System.out.println("11");
                result = Math.min(result, Integer.toString(high).length() + Math.abs(high - N));
                isStop = true;
            }
            
            if(isStop) break;

            low--;
            high++;
            if(low < 0) low = 0;
        }
    }
}
