package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SWEA_1868_파핑파핑_지뢰찾기 {
    static char[][] chr;
    static int N, size, result;
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1}, dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int n = 1; n <= N; n++){
            size = Integer.parseInt(br.readLine());
            chr = new char[size][size];
            visited = new boolean[size][size];
            result = 0;
            for(int s = 0; s < size; s++) chr[s] = br.readLine().toCharArray();

            for(int y = 0; y <size; y++){
                for(int x = 0; x < size; x++){
                    if(!visited[y][x] && chr[y][x] == '.' && !hasLandMine(y, x)) {
                        bfs(y, x);
                        result++;
                    }
                }
            }

            for(int y = 0; y <size; y++){
                for(int x = 0; x < size; x++){
                    if(!visited[y][x] && chr[y][x] == '.') result++;
                }
            }
            sb.append("#").append(n).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    /* 범위를 벗어나면 false*/
    static boolean isRange(int y, int x){
        return y < 0 || x < 0 || y >= size || x >= size;
    }

    /* 범위내에 지뢰가 있거나 유효하지 않는 범위라면 true
    *  없다면 false */
    static boolean hasLandMine(int y, int x){
        for(int d = 0; d < 8; d++){
            int ny = dy[d] + y;
            int nx = dx[d] + x;
            if(isRange(ny, nx)) continue;
            if(chr[ny][nx] == '*') return true;
        }
        return false;
    }
    static void bfs(int y, int x){
        visited[y][x] = true;
        queue.add(new Node(y, x));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(hasLandMine(node.y, node.x)) continue;
            for(int d = 0; d < 8; d++){
                int ny = dy[d] + node.y;
                int nx = dx[d] + node.x;
                if(isRange(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx));
            }
        }
    }
    static class Node{
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
