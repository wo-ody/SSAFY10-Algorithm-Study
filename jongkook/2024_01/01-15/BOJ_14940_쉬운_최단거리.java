package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운_최단거리 {
    static int col, row;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[col][row];
        visited = new boolean[col][row];

        for(int c = 0; c < col; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++){
                int value = Integer.parseInt(st.nextToken());

                if(value == 2) {
                    queue.add(new Node(c, r));
                    map[c][r] = 0;
                    visited[c][r] = true;
                }
                else map[c][r] = value;
            }
        }
        bfs();
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(map[i][j] == 1 && !visited[i][j]) sb.append(-1).append(" ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;
            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || nx < 0 || ny >= col || nx >= row || visited[ny][nx] || map[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                map[ny][nx] = map[y][x] + 1;
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

        @Override
        public String toString(){
            return "[" + x + " " + y + "]";
        }
    }
}