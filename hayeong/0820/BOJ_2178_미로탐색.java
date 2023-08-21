import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
    static int n, m;
    static int[][] board;

    static int[][]visited;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i<n; i++){
            String s = br.readLine();
            for(int j = 0; j<m; j++){
                s.charAt(j);
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs(0, 0);

        System.out.println(visited[n-1][m-1]);

    }
    static void bfs(int x, int y){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        queue.offer(y);
        visited[x][y] = 1;

        while(!queue.isEmpty()){
            int curX = queue.poll();
            int curY = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(canGo(nx, ny)){
                    queue.offer(nx);
                    queue.offer(ny);
                    visited[nx][ny] = visited[curX][curY]+1;
                }
            }
        }
    }

    static boolean canGo(int x, int y){
        if(x <0 || x>=n || y<0 || y>=m){
            return false;
        }
        if(visited[x][y]!=0){
            return false;
        }
        if(board[x][y] == 0){
            return false;
        }
        return true;
    }

}
