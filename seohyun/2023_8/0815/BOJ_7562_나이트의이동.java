package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562_나이트의이동 {
    static int T,I;
    static int[][] map;
    static Node start,end;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,-2,-1,1,2};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T ; tc++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            start = new Node(sx,sy);

            st = new StringTokenizer(br.readLine());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());
            end = new Node(endx,endy);
            //
            System.out.println(solve());
        }
    }

    public static int solve(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.x == end.x && cur.y == end.y){
                break;
            }
            for (int k = 0; k < 8; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= I || ny < 0 || ny >= I || map[nx][ny] != 0) continue;
                queue.add(new Node(nx,ny));
                map[nx][ny] = map[cur.x][cur.y] + 1;
            }
        }

        return map[end.x][end.y];
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
