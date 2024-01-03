import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Point> cheeseList;
    static int cheeseCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cheeseList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    cheeseList.add(new Point(i, j));
                    cheeseCnt++;
                }
            }
        }


        int cnt = 0;
        while(cheeseCnt != 0){
            cnt++;
            visited = new boolean[N][M];
            // 외부공기 표시
            bfs(new Point(0, 0));
            melting();
        }
        System.out.println(cnt);
    }


    static void melting(){
        for(int i = 0; i<cheeseList.size(); i++){
            Point cur = cheeseList.get(i);
            int cnt = 0;
            for(int j = 0; j<4; j++){
                int nx = cur.x+dx[j];
                int ny = cur.y+dy[j];
                if( board[nx][ny] == 2){
                    cnt++;
                }
            }
            if(cnt >= 2){
                board[cur.x][cur.y] = 0;
                cheeseCnt--;
                cheeseList.remove(i);
                i--;
            }
        }
    }

    static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;
        board[point.x][point.y] = 2;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];
                if(inRange(nx, ny) && board[nx][ny] != 1 && !visited[nx][ny]){
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    board[nx][ny] = 2;
                }
            }
        }
    }

    static boolean inRange(int x, int y){
        if(x<0 || x >=N || y<0 || y>=M){
            return false;
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
