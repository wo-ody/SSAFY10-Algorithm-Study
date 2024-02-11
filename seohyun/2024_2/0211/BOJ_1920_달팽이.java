package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1913_달팽이 {
    static int N, num;
    static int[][] map;

    static int rx,ry;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        map = new int[N][N];

        simulation();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(rx).append(" ").append(ry);

        System.out.println(sb);
    }

    static void simulation(){

        int su = 1;
        int cx = N/2;
        int cy = N/2;

        map[cx][cy] = su;

        int cnt = 1;
        int dir = 0;

        while(true){

            for (int i = 0; i < cnt; i++) {
                cx += dx[dir];
                cy += dy[dir];
                map[cx][cy] = ++su;

                if(su == num){
                    rx = cx + 1;
                    ry = cy + 1;
                }
                if(cx == 0 && cy == 0) return;
            }

            dir = (dir + 1) % 4;

            if(dir == 0 || dir == 2) cnt++;
        }
    }
}
