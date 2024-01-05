package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1806_부분합 {
    static int col, row, T, map[][];
    static int[] dx = {-1, 1, 0 ,0}, dy = {0, 0, -1, 1};
    static StringTokenizer st;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            mapping(y1, x1, y2, x2);
        }
//        print();
        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                if(map[c][r] == 0) pq.add(search(c, r));
            }
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()) System.out.printf("%d ", pq.poll());
    }
    static void mapping(int y1, int x1, int y2, int x2){
        int maxY = Math.max(y1, y2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int minX = Math.min(x1, x2);

        for(int y = minY; y < maxY; y++){
            for(int x = minX; x < maxX; x++){
                if(map[y][x] == 0) map[y][x] = 1;
            }
        }
    }
    static int search(int y, int x){
        Queue<Node> queue = new ArrayDeque<>();
        int result = 1;
        queue.add(new Node(y, x));
        map[y][x] = 1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int mx = node.x;
            int my = node.y;
            for(int d = 0; d < 4; d++){
                int ny = my + dy[d];
                int nx = mx + dx[d];
                if(nx < 0 || ny < 0 || ny >= col || nx >= row || map[ny][nx] == 1) continue;
                map[ny][nx] = 1;
                queue.add(new Node(ny, nx));
                result++;
            }
        }
        return result;
    }
    static void print(){
        for(int[] maps : map) System.out.println(Arrays.toString(maps));
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
