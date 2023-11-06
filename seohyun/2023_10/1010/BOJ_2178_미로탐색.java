package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178_미로탐색 {
    static int N,M;
    static char[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        int[][] visited = new int[N][M];

        q.add(new Node(0,0));
        visited[0][0] = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(isCango(nx,ny) == false || visited[nx][ny] != 0 || map[nx][ny] == '0') continue;
                q.add(new Node(nx,ny));
                visited[nx][ny] = visited[cur.x][cur.y] + 1;
            }
        }

        return visited[N-1][M-1];
    }

    static boolean isCango(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
