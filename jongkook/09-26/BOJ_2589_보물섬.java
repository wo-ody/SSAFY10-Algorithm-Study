package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
    static int col, row, result;
    static char[][] chr;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        chr = new char[col][row];
        int comp = 0;
        for(int i = 0; i < col; i++) {
            String str = br.readLine();
            for(int j = 0; j < row; j++){
                chr[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < col ; i++){
            for(int j = 0; j < row; j++){
                if(chr[i][j] == 'L'){
                    comp = treasure(i,j);
                    result = Math.max(result, comp);
                }
            }
        }
        System.out.println(result);
    }
    static int treasure(int y, int x){
        int methodResult = 0;
        boolean[][] visited = new boolean[col][row];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x, 0));
        visited[y][x] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col || visited[ny][nx] || chr[ny][nx] == 'W') continue;

                visited[ny][nx] = true;
                queue.add(new Node(ny, nx, node.distance + 1));
                methodResult = Math.max(methodResult, node.distance+1);

            }
        }
        return methodResult;
    }

    static class Node{
        int y, x, distance;

        public Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
