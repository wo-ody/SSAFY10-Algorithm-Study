package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20125_쿠키의신체측정 {
    static int N;
    static char[][] arr;

    static int hx,hy;
    static int[] result = new int[5];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        //
        simulation();
        System.out.println((hx+1) + " " + (hy+1));
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static int get_size(int x,int y, int dx, int dy){
        int cnt = 0;
        int nx = x;
        int ny = y;

        while(true){
            arr[nx][ny] = '_';
            nx += dx;
            ny += dy;

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == '_') break;
            cnt++;
        }

        return cnt;
    }

    static void heart(int x, int y){
        //왼쪽팔
        result[0] = get_size(x,y,0,-1);
        //오른쪽팔
        result[1] = get_size(x,y,0,1);
        //허리
        result[2] = get_size(x,y,1,0);

    }

    static void simulation(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == '_') continue;
                if(cnt==0) {
                    hx = i + 1;
                    hy = j;
                    heart(hx, hy);
                    cnt++;
                }
                else if(cnt == 1){
                    result[3] = get_size(i,j,1,0) + 1;
                    cnt++;
                }
                else{
                    result[4] = get_size(i,j,1,0) + 1;
                }
            }
        }
    }

}
