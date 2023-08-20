package codingstudy;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_17281_⚾ {
    static int T, occurScore[][], strikers[], count, src[] = new int[10], max = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        occurScore = new int[T][10];
        visited = new boolean[10];
        strikers = new int[10];

        visited[4] = true;
        strikers[4] = 1;


        for(int i = 0; i < 10; i++) src[i] = i;

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++){
                occurScore[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(2);
//        strikers = new int[]{0, 2,3,4,1,5,6,7,8,9};
//        baseBall();
        System.out.println(max);
    }
    static void perm(int cnt){
        if(cnt == 10){
//            System.out.println("dasdad");
            baseBall();
            return;
        }
        for(int i = 1; i <= 9; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            strikers[i] = cnt;
            perm(cnt+1);
            visited[i] = false;
        }
    }
    static void baseBall(){
        int score = 0;
        int i = 1;
        for(int t = 0; t < T; t++){
            boolean[] baseLine = new boolean[4];
            int out = 0;
            while(out < 3){
                if(occurScore[t][strikers[i]] == 0){
                    out++;
                }
                // 3루타
                else if (occurScore[t][strikers[i]] == 3){
                    if(baseLine[3]){
                        score++;
                    }
                    if(baseLine[2]){
                        baseLine[2] = false;
                        score++;
                    }
                    if(baseLine[1]){
                        baseLine[1] = false;
                        score++;
                    }
                    baseLine[3] = true;

                }
                // 2루타
                else if (occurScore[t][strikers[i]] == 2) {
                    if (baseLine[3]) {
                        baseLine[3] = false;
                        score++;
                    }

                    if (baseLine[2]) {
                        score++;
                    }
                    if (baseLine[1]) {
                        baseLine[1] = false;
                        baseLine[3] = true;
                    }

                    baseLine[2] = true;

                }
                // 1루타 일때
                else if (occurScore[t][strikers[i]] == 1) {
                    if (baseLine[3]) {
                        baseLine[3] = false;
                        score++;
                    }

                    if (baseLine[2]) {
                        baseLine[3] = true;
                        baseLine[2] = false;
                    }

                    if (baseLine[1]) {
                        baseLine[2] = true;
                    }

                    baseLine[1] = true;

                }

                else if(occurScore[t][strikers[i]] == 4){
                    if (baseLine[3]) {
                        baseLine[3] = false;
                        score++;
                    }

                    if (baseLine[2]) {
                        baseLine[2] = false;
                        score++;
                    }
                    if (baseLine[1]) {
                        baseLine[1] = false;
                        score++;
                    }
                    score++;
                }
                i++;
                if(i >= 10){
                    i = 1;
                }
            }
        }
        max = Math.max(score,max);
    }
}
