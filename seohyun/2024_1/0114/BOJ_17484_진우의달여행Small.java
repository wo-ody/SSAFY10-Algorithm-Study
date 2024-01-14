package boj;

import java.io.*;
import java.util.*;

public class boj_17484_진우의달여행Small {
    static int N,M;
    static int[][] arr;
    static int[] dy = {-1,0,1};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        System.out.println(result);

    }

    static void bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(x,y,-1,arr[x][y]));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == N-1){
                result = Math.min(result, cur.fuel);
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if(cur.d == i) continue;
                int nx = cur.x + 1;
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                int nfuel = cur.fuel + arr[nx][ny];
                q.add(new Node(nx,ny,i,nfuel));
            }
        }
    }

    static void simulation(){
        for (int i = 0; i < M; i++) {
            bfs(0,i);
        }
    }

    static class Node{
        int x,y,d, fuel;
        Node(int x, int y, int d, int fuel){
            this.x = x;
            this.y = y;
            this.d = d;
            this.fuel = fuel;
        }
    }
}
