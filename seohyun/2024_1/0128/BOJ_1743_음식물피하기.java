package boj;

import java.io.*;
import java.util.*;

public class boj_1743_음식물피하기 {
    static int N,M,K;
    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }
        // simulation
        simulation();
    }

    static int bfs(boolean[][] visited, int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        int cnt = 0;

        q.add(new Node(x,y));
        visited[x][y] = true;
        cnt++;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
                q.add(new Node(nx,ny));
                visited[nx][ny] = true;
                cnt++;
            }
        }
        return cnt;
    }


    static void simulation(){
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0 || visited[i][j]) continue;
                result = Math.max(result, bfs(visited,i,j));
            }
        }

        System.out.println(result);
    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
