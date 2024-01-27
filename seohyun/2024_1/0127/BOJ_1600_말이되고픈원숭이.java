package boj;

import java.io.*;
import java.util.*;

public class boj_1600_말이되고픈원숭이 {
    static int K,W,H; // W : 가로, H : 세로
    static int[][] map;

    static int[] hdx = {-2,-2,-1,-1,1,1,2,2};
    static int[] hdy = {-1,1,-2,2,-2,2,-1,1};
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // simulation
        System.out.println(simulation());
    }

    static int simulation() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[K+1][H][W];

        q.add(new Node(K,0,0,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == H-1 && cur.y == W-1){
                return cur.cnt;
            }

            if(cur.k > 0){ // 말 이동
                for (int k = 0; k < 8; k++) {
                    int nx = cur.x + hdx[k];
                    int ny = cur.y + hdy[k];

                    if(!isPossible(nx,ny) || visited[cur.k-1][nx][ny] || map[nx][ny] == 1) continue;
                    q.add(new Node(cur.k - 1, nx,ny, cur.cnt + 1));
                    visited[cur.k-1][nx][ny] = true;
                }
            }
            // 상하좌우 이동
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(!isPossible(nx,ny) || visited[cur.k][nx][ny] || map[nx][ny] == 1) continue;
                q.add(new Node(cur.k, nx,ny, cur.cnt + 1));
                visited[cur.k][nx][ny] = true;
            }

        }
        return -1;
    }

    static boolean isPossible(int x, int y){
        if(x < 0 || x >= H || y < 0 || y >= W) return false;
        return true;
    }

    static class Node{
        int k,x,y,cnt;

        public Node(int k, int x, int y, int cnt) {
            this.k = k;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
