package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int row, col, W, B, cnt = 1;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        visited = new boolean[row][col];
        for(int r = 0; r < row; r++) map[r] = br.readLine().toCharArray();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;

                char soldier = map[i][j];

                cnt = 1;
                recursive(i, j, soldier);

                if(soldier == 'B') B += cnt * cnt;
                else W += cnt * cnt;
            }
        }
        System.out.println(W + " " + B);
    }

    static void recursive(int rRow, int rCol, char soldier){
        for(int d = 0; d < 4; d++){
            int nx = dx[d] + rRow;
            int ny = dy[d] + rCol;
            if(nx < 0 || ny < 0 || nx >= row || ny >= col || visited[nx][ny] || map[nx][ny] != soldier) continue;
            cnt++;
            visited[nx][ny] = true;
            recursive(nx, ny, soldier);
        }

    }

}
