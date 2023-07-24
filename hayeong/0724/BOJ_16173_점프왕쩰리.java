import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 점프왕쩰리 {
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        bfs(0, 0);

        if(visited[n-1][n-1]){
            System.out.println("HaruHaru");
        } else{
            System.out.println("Hing");
        }
    }

    public static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int curX = queue.poll();
            int curY = queue.poll();
            step = board[curX][curY];
            for (int i = 0; i < 2; i++) {
                int nx = curX + dx[i] * step;
                int ny = curY + dy[i] * step;
                if (canGo(nx, ny)) {
                    queue.offer(nx);
                    queue.offer(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean canGo(int x, int y){
        if(x<0 || x >=n || y<0 || y>=n){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        return true;
    }
}
