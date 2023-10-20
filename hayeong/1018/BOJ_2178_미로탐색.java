import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    static int N, M;
    static char[][] board;
    static int[][] visit;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        bfs(0, 0);

        System.out.println(visit[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        visit[x][y] = 1;
        q.add(x);
        q.add(y);

        while (!q.isEmpty()) {
            int curx = q.poll();
            int cury = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if (canGo(nx, ny)) {
                    visit[nx][ny] = visit[curx][cury] + 1;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        if(board[x][y] == '0') return false;
        if(visit[x][y] != 0) return false;

        return true;
    }
}
