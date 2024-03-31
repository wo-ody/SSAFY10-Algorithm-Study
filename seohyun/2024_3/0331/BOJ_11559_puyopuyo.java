import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[12][6];
    static int result = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        simulation();

    }

    static int BFS(int x, int y, boolean[][] visited){
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> tmp = new ArrayDeque<>();

        char color = map[x][y];
        q.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            tmp.add(cur);

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny]) continue;
                if(map[nx][ny] == color){
                    q.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }

        if(tmp.size() >= 4){
            while(!tmp.isEmpty()){
                Node cur = tmp.poll();
                map[cur.x][cur.y] = '.';
            }
            return 0;
        }
        return 1;

    }

    static void set_gravity(){

        for (int j = 0; j < 6; j++) {
            int px = 11;
            for (int i = 11; i >= 0 ; i--) {
                if(map[i][j] != '.'){
                    if(px != i){
                        map[px][j] = map[i][j];
                        map[i][j] = '.';
                    }
                    px--;
                }
            }
        }
    }

    static void simulation(){

        while(true){
            int flag = 1;

            boolean[][] visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(map[i][j] == '.' || visited[i][j]) continue;
                    flag *= BFS(i,j,visited);
                }
            }

            if(flag == 1) break;
            result++;

            // 중력 작용
            set_gravity();
        }

        System.out.println(result);
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
