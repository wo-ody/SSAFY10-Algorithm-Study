public class 안전지대 {
    public int solution(int[][] board) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        int n = board.length;
        int m = board[0].length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                            board[nx][ny] = -1;
                            cnt++;

                        }
                    }
                }
            }
        }
        return n*m - cnt;
    }
}
