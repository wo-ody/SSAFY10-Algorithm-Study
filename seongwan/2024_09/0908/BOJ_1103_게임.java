import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static char[][] board;
    static boolean[][] visit;
    static int[][] dp;
    static boolean check;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visit = new boolean[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        visit[0][0] = true;
        int ans = dfs(0, 0);
        if (check)
            System.out.println(-1);
        else {
            System.out.println(ans);
        }
    }

    static int dfs(int r, int c) {
        if (check)
            return -1;
        if (board[r][c] == 'H')
            return dp[r][c];

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir] * (board[r][c] - '0');
            int nc = c + dc[dir] * (board[r][c] - '0');

            if (canGo(nr, nc)) {
                if (visit[nr][nc]) {
                    check = true;
                    return -1;
                }
                if (dp[nr][nc] > 0) {
                    dp[r][c] = Math.max(dp[r][c], dp[nr][nc] + 1);
                    continue;
                }
                visit[nr][nc] = true;
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
                visit[nr][nc] = false;
            }
        }
        return dp[r][c] = Math.max(dp[r][c], 1);
    }

    static boolean canGo(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
