/*
 *  08.26 김창희
 *  BOJ_14500_테트로미노
 *
 *  [풀이]
 *  1. 모든 블럭은 면이 맞닿은 4칸으로 이루어져있으므로 하나의 칸에서 depth가 4일때까지 dfs로 탐색한다.
 *  2. 하지만 ㅗ블럭은 dfs탐색으로 나올수 없다. 
 *  3. 위를 해결하기 위해 depth가 2인 시점에서 상하좌우를 볼수 있게 갱신된 좌표가 아닌 현재의 좌표에서 dfs탐색을 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = true;
                tetris(i, j, 1, map[i][j]);
                v[i][j] = false;
            }
        }
        System.out.println(answer);

    }

    public static void tetris(int x, int y, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (!v[nx][ny]) {
                if(depth == 2){
                    v[nx][ny]==true;
                    tetris(x,y,depth+1,sum+map[nx]);
                    v[nx][ny]==false;
                }
                v[nx][ny] = true;
                tetris(nx, ny, depth + 1, sum + map[nx][ny]);
                v[nx][ny] = false;
            }
        }
    }

}
