package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토_2 {
    static int col, row, max;
    static int[][] map;
    static Queue<Node> queue = new ArrayDeque<>();
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[col][row];

        for(int c = 0; c < col; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++){
                int value = Integer.parseInt(st.nextToken());
                map[c][r] = value;
                if(value == 1) queue.add(new Node(c, r));
            }
        }

        bfs();

        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                if(map[c][r] == 0) {System.out.println(-1); return;}
                max = Math.max(max, map[c][r]);
            }
        }
//        for(int[] m : map) System.out.println(Arrays.toString(m));
        System.out.println(max - 1);
    }
    static void bfs(){
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= col || nx >= row || map[ny][nx] != -0) continue;
                map[ny][nx] =map[y][x] +  1;
                queue.add(new Node(ny, nx));
            }
        }
    }
    static class Node{
        int y, x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
