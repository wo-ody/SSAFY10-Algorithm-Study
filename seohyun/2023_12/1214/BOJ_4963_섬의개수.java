package boj;

import java.io.*;
import java.util.*;

public class boj_4963_섬의개수 {
    static int W, H;
    static int[][] map;

    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            if(W == 0 && H == 0) break;
            
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // BFS 돌리기
            int result = simulation();
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(boolean[][] visited, int x, int y){
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for (int k = 0; k < 8; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || nx >= H || ny < 0 || ny >= W ) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                q.add(new Node(nx,ny));
                visited[nx][ny] = true;
            }
        }
    }

    static int simulation(){
        boolean[][] visited = new boolean[H][W];

        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue; // 이게 순서가 ..
                bfs(visited, i, j);
                cnt++;
            }
        }

        return cnt;
    }

    static class Node{
        int x,y;
        Node(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }
}
