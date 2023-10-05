package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5212_지구온난화 {
    static int R;
    static int C;
    static char[][] map;
    static int ya = -1, yb = -1;
    static int xa = -1, xb = -1;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void erase_ground(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'X'){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '.') cnt++;
                    }
                    if (cnt >= 3) map[i][j] = '-';
                }
            }
        }
    }

    public static void print_result(){
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if(map[i][j] == 'X') ya = j;
            }
            if(ya != -1) break;
        }

        for (int j = C-1; j >= 0; j--) {
            for (int i = R-1; i >= 0; i--) {
                if(map[i][j] == 'X') yb = j;
            }
            if(yb != -1) break;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'X') xa = i;
            }
            if(xa != -1) break;
        }

        for (int i = R-1; i >= 0; i--) {
            for (int j = C-1; j >= 0; j--) {
                if(map[i][j] == 'X') xb = i;
            }
            if(xb != -1) break;
        }

        for(int i=xa;i<=xb;i++){
            for(int j=ya;j<=yb;j++){
                if(map[i][j] == '-') System.out.print('.');
                else System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        erase_ground();
        print_result();

    }
}
