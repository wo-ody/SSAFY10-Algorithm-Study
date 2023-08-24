package graph;

import java.util.*;
import java.io.*;
public class BOJ_1012_유기농_배추 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map, location;

    static boolean[][] visited;
    static int col, row, number, count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            number = Integer.parseInt(st.nextToken());
            map = new int[col][row];
            location = new int[col][row];
            visited = new boolean[col][row];

            count = 0;

            for(int i = 0; i < number; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            for(int i = 0; i < col; i++){
                for(int j = 0; j < row; j++){
                    if(map[i][j] == 1){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void dfs(int y, int x){
        visited[y][x] = true;
        map[y][x] = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!check(ny, nx)) continue;
            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }
    static boolean check(int movingY, int movingX){
        if(movingY < 0 || movingX < 0 || movingX >= row || movingY >= col || map[movingY][movingX] == 0) return false;
        return true;
    }
}
