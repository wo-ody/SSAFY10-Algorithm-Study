package gus0_0th;

import java.io.*;
import java.util.*;

public class boj_3190_뱀 {
    static Queue<Node> change = new ArrayDeque<>();
    static Deque<Node> snake = new ArrayDeque<>();
    static int snake_dir;
    
    static int N,K,L;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            change.add(new Node(x,c));
        }

        // simulation
        simulation();
        
    }

    static boolean isExit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] == 2) return true;
        return false;
    }

    static int change_dir(int curd, char c){
        int dir = 0;

        if(curd == 0){
            if(c == 'L') dir = 2;
            else dir = 3;
        }
        else if(curd == 1){
            if(c == 'L') dir = 3;
            else dir = 2;
        }
        else if(curd == 2){
            if(c == 'L') dir = 1;
            else dir = 0;
        }
        else{
            if(c == 'L') dir = 0;
            else dir = 1;
        }

        return dir;
    }

    static void simulation(){
        snake.add(new Node(0,0));
        snake_dir = 3;
        map[0][0] = 2;

        int time = 0;
        while(true){
            time++;

            Node cur = snake.peek();

            int nx = cur.x + dx[snake_dir];
            int ny = cur.y + dy[snake_dir];

            if(isExit(nx,ny)) break;

            snake.addFirst(new Node(nx,ny));
            if(map[nx][ny] == 1){
                map[nx][ny] = 2;
            }else{
                Node tail = snake.pollLast();
                map[tail.x][tail.y] = 0;
                map[nx][ny] = 2;
            }

            if(!change.isEmpty() && change.peek().x == time){
                snake_dir = change_dir(snake_dir, change.peek().c);
                change.poll();
            }
        }

        System.out.println(time);
    }


    static class Node{
        int x,y;
        char c;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        Node(int x, char c){
            this.x = x;
            this.c = c;
        }
    }
}
