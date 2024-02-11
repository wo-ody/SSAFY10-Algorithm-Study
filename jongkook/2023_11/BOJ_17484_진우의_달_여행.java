package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17484_진우의_달_여행 {
    static int[] dx, dy;
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력 완료
        dx = new int[]{1, 1, 1};
        dy = new int[]{-1, 0, 1};
        for(int l = 0; l < m; l++) {
            int ans = 0;
            ans += map[0][l];
            dfs(0, l, ans, 3);
        }
        System.out.println(answer);
    }// end of main
    private static void dfs(int x, int y, int ans, int dir){
        if(x == n - 1){ //기저조건 : x가 맵 끝에 왔을 때
            if(ans < answer) answer = ans;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( (dir != i) && isIn(nx,ny)){//가장 최근에 움직인 방향이 아니라면
                dfs(nx, ny, ans + map[nx][ny], i);
            }
        }
    }
    private static boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
