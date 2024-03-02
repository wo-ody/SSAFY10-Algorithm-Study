package boj;

import java.io.*;
import java.util.*;

public class boj_2206_벽부수고이동하기 {
    static class Node{
        int x,y,cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[][] map;
    static int[][][] result;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        simulation();
    }

    static void simulation(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];

        q.add(new int[]{0,0,0});
        visited[0][0][0] = true;
        result[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if(x == N -1 && y == M-1){
                System.out.println(result[N-1][M-1][cnt]);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][cnt]) continue;
                if(map[nx][ny] == 1){
                    if(cnt == 0){ // 한번 부술 수 있음
                        q.add(new int[] {nx,ny,cnt + 1});
                        visited[nx][ny][1] = true;
                        result[nx][ny][1] = result[x][y][0] + 1 ;
                    }
                }
                else {
                    q.add(new int[] {nx, ny, cnt});
                    visited[nx][ny][cnt] = true;
                    result[nx][ny][cnt] = result[x][y][cnt] + 1;
                }
            }
        }

        System.out.println(-1);
    }
}
