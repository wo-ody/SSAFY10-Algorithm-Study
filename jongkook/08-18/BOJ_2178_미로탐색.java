package codingstudy;

import java.io.*;
import java.util.*;

public class BOJ_2178_미로탐색 {
    static int col, row, map[][];
    static char[][] chars;
    static int[] dx = {-1,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];

        visited = new boolean[col][row];

        for(int i = 0; i <col; i++) {
            String s = br.readLine();
            for(int j = 0; j < row; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
    bfs(0,0);
    System.out.println(map[col-1][row-1]);
    }
    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            for(int d = 0; d < 4; d++){
                int nx = currentX + dx[d];
                int ny = currentY + dy[d];
                if(nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                map[nx][ny] = map[currentX][currentY] + 1;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;

            }
        }

    }
}
