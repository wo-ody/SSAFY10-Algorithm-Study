package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17144_미세먼지안녕 {
    static class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R,C,T;
    static int[][] map;
    static List<Point> cleaner = new ArrayList<>();

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void print(int[][] arr){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCango(int x, int y) {
        if(x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }

    public static void spread_dust(){
        // 0 이거나 -1 이면 제외
        // # 1 : 2차원 배열 깊은 복사본 저장

        // # 2 : 먼지있는 좌표와 먼지 값을 저장
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            tmp[i] = Arrays.copyOf(map[i],C);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1 || map[i][j] == 0) continue;
                int dust = map[i][j];
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(!isCango(nx,ny) || map[nx][ny] == -1) continue;
                    tmp[nx][ny] += dust / 5;
                    cnt++;
                }
                tmp[i][j] -= (dust/5 * cnt);
            }
        }
        for (int i = 0; i < R; i++) {
            map[i] = Arrays.copyOf(tmp[i],C);
        }
    }

    public static void rotate(int x, int y, int[] dir){
        int idx = 0;
        int before, nxt;
        int nx,ny;
        before = map[x][y];
        map[x][y] = 0;
        while(true){
            nx = x + dx[dir[idx]];
            ny = y + dy[dir[idx]];
            if(!isCango(nx,ny)) {
                idx++;
                continue;
            }
            if(map[nx][ny] == -1) break;
            nxt = map[nx][ny];

            map[nx][ny] = before;
            //map[x][y] = 0; 처음 한번만 해주면 됨
            x = nx;
            y = ny;
            before = nxt;
        }

    }

    public static int get_result(){
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1 || map[i][j] == 0) continue;
                result += map[i][j];
            }
        }
        return result;
    }

    public static void solve(){
        for (int i = 0; i < T; i++) {
            spread_dust();
            //print(map);
            rotate(cleaner.get(0).x,cleaner.get(0).y,new int[]{3,0,2,1});
            rotate(cleaner.get(1).x,cleaner.get(1).y,new int[]{3,1,2,0});
            //print(map);
        }
        System.out.println(get_result());
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) cleaner.add(new Point(i,j + 1));
            }
        }

        solve();

    }
}
