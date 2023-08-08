package codingtest.BOJ;

import java.io.*;
import java.util.*;


public class BOJ_2630_색종이_만들기 {
    static int blue, white , colorPaper[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        colorPaper = new int[T][T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < T; j++) colorPaper[i][j] = Integer.parseInt(st.nextToken());
        }
        slice(0, 0, T);
        System.out.println(white);
        System.out.println(blue);


    }
    static void slice(int row, int col, int size){
        if(check(row, col, size)){
            if(colorPaper[row][col] == 0) white++;
            else blue++;
            return;
        }
        int nextSize = size/2;
        slice(row, col, nextSize);
        slice(row + nextSize, col, nextSize);
        slice(row, col + nextSize, nextSize);
        slice(row + nextSize, col + nextSize, nextSize);
    }
    static boolean check(int row, int col, int size){
        int color = colorPaper[row][col];
        for(int i = row; i < row + size; i++){
            for (int j = col; j < col + size; j++) {
                if(colorPaper[i][j] != color) return false;

            }
        }
        return true;

    }
}
