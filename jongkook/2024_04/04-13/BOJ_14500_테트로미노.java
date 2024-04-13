import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, M, MAX_SIZE = Integer.MIN_VALUE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // X
        N = Integer.parseInt(st.nextToken());
        // Y
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int n = 0 ; n < N; n++){
            for(int m = 0; m < M; m++){
                visited[n][m] = true;
                recursive(n, m, 1, map[n][m]);
                visited[n][m] = false;
            }
        }
        System.out.println(MAX_SIZE);
    }

    static void recursive(int x, int y, int depth, int sum){
        if(depth == 4){
            MAX_SIZE = Math.max(MAX_SIZE, sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if(!isRange(nx, ny)) continue;

            int value = map[nx][ny];

            if(depth == 2){
                visited[nx][ny] = true;
                recursive(x, y, depth+1, sum+value);
                visited[nx][ny] = false;
            }
            visited[nx][ny] = true;
            recursive(nx, ny, depth+1, sum+value);
            visited[nx][ny] = false;
        }
    }
    // 범위 안이면서 방문한 적이 없다면 true;
    static boolean isRange(int x, int y){
        return (x >= 0 && y >= 0 && x < N && y < M && !visited[x][y]);
    }
}
