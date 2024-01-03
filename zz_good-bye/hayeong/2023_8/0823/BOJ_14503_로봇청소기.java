import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
    static int N, M;
    static int[][] board; // 0: 청소되지 않은 빈칸, 1: 벽
    static int dir; // 0: 북, 1: 동, 2: 남, 3: 서
    static int curX, curY;

    static int[] dx = {-1, 0, 1, 0};// 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] cleaned; // 청소여부 판단

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cleaned = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        curX = Integer.parseInt(st.nextToken());
        curY = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시뮬레이션
        while (true) {
            // 1. 만약 현재위치를 청소한 적이 없다면 청소
            if (!cleaned[curX][curY]) {
                cleaned[curX][curY] = true;
            }
            int cnt = 0; // 사방에 청소하지 않은 빈칸이 있는지 여부를 판단할 변수
            for (int i = 0; i < 4; i++) { // 4방을 돌아보며
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (canGo(nx, ny)) { // 3. 주변 네칸 중 청소되지 않은 빈칸이 있다면
                    cnt++; // 개수를 늘려주고
                    dir = (dir + 3) % 4; // 반시계 방향으로 회전
                    // 앞쪽 칸
                    int frontX = curX + dx[dir];
                    int frontY = curY + dy[dir];
                    if (canGo(frontX, frontY)) { // 앞쪽칸이 청소되지 않은 빈칸이라면 이동
                        curX = frontX;
                        curY = frontY;
                        break; // 1로 이동
                    }
                }
            }
            if (cnt == 0) { // 2. 4방에 청소되지 않은 빈칸이 없는 경우
                // 바라보는 방향을 유지한채 한칸뒤
                int backX = curX + dx[(dir + 2) % 4];
                int backY = curY + dy[(dir + 2) % 4];
                if (InRange(backX, backY) && board[backX][backY] != 1) { // 후진할 수 있으면 후진
                    curX = backX;
                    curY = backY;
                } else { // 후진할 수 없다면 작동 멈춤
                    break;
                }
            }
        }

        // 청소한 칸 세어주기
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cleaned[i][j]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }

    static boolean InRange(int x, int y) { // 범위 체크
        if (x < 0 || x >= N || y < 0 || y >= M)
            return false;
        return true;
    }

    static boolean canGo(int x, int y) {
        if (!InRange(x, y)) // 범위 밖이거나
            return false;

        if (board[x][y] == 1) // 벽이거나
            return false;
        if (cleaned[x][y]) // 청소한적 있으면
            return false;
        return true;
    }
}
