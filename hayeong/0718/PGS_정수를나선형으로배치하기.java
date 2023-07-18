public class 정수를나선형으로배치하기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    int N;

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        visited = new boolean[n][n];
        N = n;


        int x = 0;
        int y = 0;
        int dir = 0;
        answer[0][0] = 1;
        visited[0][0] = true;


        for (int i = 2; i <= n * n; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (canGo(nx, ny)) {
                answer[nx][ny] = i;
            } else {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
                answer[nx][ny] = i;

            }
            visited[nx][ny] = true;
            x = nx;
            y = ny;

        }
        return answer;
    }

    public boolean canGo(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return true;
    }
}
