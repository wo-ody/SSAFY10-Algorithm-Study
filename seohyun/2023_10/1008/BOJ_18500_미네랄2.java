package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_18500_미네랄2 {
    static int R,C,N;
    static char[][] map;
    static int[] stick;


    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();

        N = Integer.parseInt(br.readLine());
        stick = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) stick[i] = Integer.parseInt(st.nextToken());

        simulation();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    static void destroy(int height, boolean isLeft){
        int x = R - height;
        int y;
        if(isLeft){
            y = -1;
            while(true){
                y++;
                if(!isCango(x,y)) break;
                if(map[x][y] == 'x'){
                    map[x][y] = '.';
                    break;
                }
            }
        }
        else{
            y = C;
            while(true){
                y--;
                if(!isCango(x,y)) break;
                if(map[x][y] == 'x'){
                    map[x][y] = '.';
                    break;
                }
            }
        }
    }

    static ArrayList<Node> BFS(int x, int y, boolean[][] visited){
        Queue<Node> q = new ArrayDeque<>();
        visited[x][y] = true;
        ArrayList<Node> result = new ArrayList<>();

        q.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            result.add(cur);
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(isCango(nx,ny) == false || visited[nx][ny] || map[nx][ny] == '.') continue;
                q.add(new Node(nx,ny));
                visited[nx][ny] = true;
            }
        }

        return result;
    }

    static boolean set_gravity(ArrayList<Node> cluster){
        char[][] tmp = new char[R][C];
        for (int i = 0; i < R; i++) tmp[i] = map[i].clone();
        for(Node cur : cluster) tmp[cur.x][cur.y] = '.';

        int init_x = cluster.get(0).x;
        int init_y = cluster.get(0).y;
        boolean isSetGravity;

        while(true){
            boolean impossible = false;
            for (int i = 0; i < cluster.size(); i++) {
                cluster.get(i).x += 1;
                Node cur = cluster.get(i);
                int nx = cur.x;
                int ny = cur.y;
                if(isCango(nx,ny) == false || tmp[nx][ny] == 'x') impossible = true;
            }

            if(impossible){
                for (Node cur : cluster) {
                    tmp[cur.x - 1][cur.y] = 'x';
                }
                for (int i = 0; i < R; i++) map[i] = tmp[i].clone();

                if(cluster.get(0).x - 1 == init_x && cluster.get(0).y == init_y) isSetGravity = false;
                else isSetGravity = true;
                break;
            }
        }

        return isSetGravity;
    }

    static void gravity(){
        // 수정
        /*
        떨어지는 애들 있으면 바로 함수 종료
         */

        boolean[][] visited = new boolean[R][C];

        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if(visited[i][j] || map[i][j] == '.') continue;
                // 클러스터 좌표들 구하기 (BFS)
                ArrayList<Node> result = BFS(i,j,visited);
                if(set_gravity(result)) return;
            }
        }
    }

    static void simulation(){
        for (int i = 0; i < N; i++) {
            // 미네랄 파괴
            if(i % 2 == 0) destroy(stick[i], true);
            else destroy(stick[i], false);

            // 중력 작용
            gravity();
        }


    }

    static boolean isCango(int x, int y){
        if(x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
