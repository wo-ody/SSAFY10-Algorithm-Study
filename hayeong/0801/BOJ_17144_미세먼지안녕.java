import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 17144
public class 미세먼지안녕 {
    static int R, C, T;
    static int cleaner = -1;
    static int[][] board;

    static Queue<Dust> queue;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Dust {
        int x, y, w;

        Dust(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 보드 구성
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // 공기 청정기의 위치 저장
                if (cleaner == -1 && board[i][j] == -1) {
                    cleaner = i;
                }

            }
        }

        // 확산, 공기청정기 작동
        for (int i = 0; i < T; i++) {
            checkDust(); // 미세먼지 있는 공간 확인
            spread(); // 확산
            operate(); // 작동
        }

        // 총 미세먼지의 양
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) continue;
                sum += board[i][j];
            }
        }
        System.out.println(sum);

    }

    static void checkDust() {
        queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1 || board[i][j] == 0) continue;
                // 미세먼지가 있는 공간과 미세먼지 양
                queue.add(new Dust(i, j, board[i][j]));
            }
        }

    }

    static void spread() {
        while (!queue.isEmpty()) {
            Dust cur = queue.poll();
            // 확산될 먼지가 없다면
            if (cur.w < 5) continue;
            // 확산될 먼지가 있다면
            int spreadAmount = cur.w / 5; // 확산되는 양
            int cnt = 0; // 먼지가 확산될 수 있는 방향 수
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (canSpread(nx, ny)) {
                    board[nx][ny] += spreadAmount;
                    cnt += 1;
                }
            }
            // 남은 미세먼지
            board[cur.x][cur.y] -= spreadAmount * cnt;

        }
    }


    static void operate() {

        int top = cleaner;
        int down = cleaner + 1;

        // 위쪽 공기청정기의 바람은 반시계방향 순환,
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--)
            board[i][0] = board[i - 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++)
            board[0][i] = board[0][i + 1];
        // 위로 당기기
        for (int i = 0; i < top; i++)
            board[i][C - 1] = board[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--)
            board[top][i] = board[top][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        board[top][1] = 0;

        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++)
            board[i][0] = board[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++)
            board[R - 1][i] = board[R - 1][i + 1];
        // 아래로 당기기
        for (int i = R - 1; i > down; i--)
            board[i][C - 1] = board[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--)
            board[down][i] = board[down][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        board[down][1] = 0;
    }

    static boolean canSpread(int x, int y) {
        if (x < 0 || x >= R || y < 0 || y >= C) {
            return false;
        }
        if (board[x][y] == -1) {
            return false;
        }
        return true;
    }

}
