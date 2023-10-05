package codingstudy;

import java.util.*;
import java.io.*;

public class BOJ_10163_색종이 {
    static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        paper = new int[1001][1001];
        int[][] regist = new int[T][4];
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int to_x = Integer.parseInt(st.nextToken());
            int to_y = Integer.parseInt(st.nextToken());
            regist[t] = new int[] {x, y, to_x, to_y};
            for(int i = y; i < y + to_y; i++){
                for(int j = x; j < x + to_x; j++){
                    paper[i][j] = t+1;
                }
            }
        }
        for(int t = 0; t < T; t++){
            int count = 0;
            for(int i = regist[t][1]; i < regist[t][1] + regist[t][3]; i++){
                for(int j = regist[t][0]; j < regist[t][0] + regist[t][2]; j++){
                    if(paper[i][j] == t+1) count++;
                }
            }
            System.out.println(count);
        }

    }
}
