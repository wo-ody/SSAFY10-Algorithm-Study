package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형_네개의_합집합의_면적_구하기 {
    public static void main(String[] args) throws IOException {
        boolean [][] board = new boolean[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 4 ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x = x1; x<x2; x ++){
                for(int y = y1; y < y2; y++){
                    board[x][y] = true;
                }
            }


        }
        int cnt = 0;
        for(int i = 0 ; i < 101 ; i++){
            for(int j = 0 ; j < 101 ; j ++){
                if (board[i][j])
                    cnt+= 1;
            }
        }
        System.out.println(cnt);
    }
}
