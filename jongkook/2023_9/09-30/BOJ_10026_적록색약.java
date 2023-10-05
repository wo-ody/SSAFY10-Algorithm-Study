package graph;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_10026_적록색약 {
    static char[][] rgb, rb;
    static int size;
    static int rgbCount, rbCount;
    static int[] dx = {-1, 1, 0, 0} , dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        rgb = new char[size][size];
        rb = new char[size][size];

        for(int i = 0; i < size; i++){
            String s = br.readLine();
            for (int j = 0; j < size; j++){
                char chr = s.charAt(j);
                if(chr == 'G') rb[i][j] = 'R';
                else rb[i][j] = chr;

                rgb[i][j] = chr;
            }
        }

        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
               if(rgb[i][j] != ','){
                   bfs(i, j, rgb[i][j], rgb);
                   rgbCount++;
               }
               if(rb[i][j] != ',') {
                   bfs(i, j, rb[i][j], rb);
                   rbCount++;
               }
            }
        }

        System.out.println(rgbCount + " " + rbCount);

    }
    static void bfs(int y, int x, char color, char[][] map){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x, color));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = dx[d] + node.x;
                int ny = dy[d] + node.y;
                if(nx < 0 || ny < 0 || nx >= size || ny >= size || node.color != map[ny][nx] || map[ny][nx] == ',' ) continue;
                map[ny][nx] = ',';
                queue.offer(new Node(ny, nx, node.color));
            }
        }
    }

    static class Node{
        int y, x;
        char color;

        public Node(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }
}
