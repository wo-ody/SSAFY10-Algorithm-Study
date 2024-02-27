package boj;

import java.io.*;
import java.util.*;

public class boj_7569_토마토 {
    static int M,N,H;
    static int[][][] map;

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static Queue<Node> tomato = new ArrayDeque<>();
    static int unripen = 0;

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[M][N][H];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[m][n][h] = Integer.parseInt(st.nextToken());
                    if(map[m][n][h] == 0) unripen++;
                    else if(map[m][n][h] == 1) tomato.add(new Node(m,n,h));
                }
            }
        }

        if(unripen == 0) {
            System.out.println(0);
            return;
        }
            

        bfs();
        if( unripen > 0) System.out.println(-1);
        else System.out.println(result - 1);
    }

    static void bfs(){
        while(!tomato.isEmpty()){
            Node cur = tomato.poll();

            for (int k = 0; k < 6; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                int nz = cur.z + dz[k];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) continue;
                if(map[nx][ny][nz] != 0) continue;

                map[nx][ny][nz] = map[cur.x][cur.y][cur.z] + 1;
                tomato.add(new Node(nx,ny,nz));
                result = Math.max(result, map[nx][ny][nz]);
                unripen--;
            }
        }
    }

    static class Node{
        int x,y,z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
