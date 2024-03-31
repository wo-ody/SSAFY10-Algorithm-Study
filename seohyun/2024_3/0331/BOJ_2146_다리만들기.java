import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;

    static int result = Integer.MAX_VALUE;

    static Queue<Node> outside = new ArrayDeque<>();

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
    }

    static void BFS(int x, int y, int cnt){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        map[x][y] = cnt;
        q.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    outside.add(new Node(nx,ny,cnt));
                }
                else if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    map[nx][ny] = cnt;
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void get_distance(int x, int y, int inum){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new Node(x,y,1));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(map[cur.x][cur.y] != inum && map[cur.x][cur.y] != 0){
                result = Math.min(result, cur.num - 1);
                return;
            }
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == inum) continue;

                q.add(new Node(nx, ny,cur.num + 1));
                visited[nx][ny] = true;

            }
        }
    }


    static void simulation(){

        int cnt = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] <= 0) continue;
                BFS(i,j,cnt--);
            }
        }

        while(!outside.isEmpty()){
            Node cur = outside.poll();
            get_distance(cur.x, cur.y , cur.num);
        }

        System.out.println(result);

    }

    static class Node{
        int x,y,num;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
