package boj;

import java.io.*;
import java.util.*;
public class boj_2667_단지번호붙이기 {
    static int N;
    static char[][] map;

    static int cnt;
    static ArrayList<Integer> result;

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        cnt = 0;
        result = new ArrayList<>();

        simulation();

        Collections.sort(result);

        System.out.println(cnt);
        for(int su:result) System.out.println(su);


    }

    static int bfs(int x, int y, boolean[][] visited){
        Queue<Node> q = new ArrayDeque<>();
        int cnt = 0;

        q.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            cnt++;
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (!isCango(nx, ny) || visited[nx][ny] || map[nx][ny] == '0') continue;
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return cnt;
    }
    static void simulation(){
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '0' || visited[i][j]) continue;
                result.add(bfs(i,j,visited));
                cnt++;
            }
        }
    }

    static boolean isCango(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
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
