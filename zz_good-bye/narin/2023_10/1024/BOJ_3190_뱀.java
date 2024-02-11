import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, L, sec;
    private static int[][] board;
    private static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 우 하 좌 상 (시계방향)
    private static Deque<Point> snake, change;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void move() {

        int d = 0;  // 시작하는 방향은 오른쪽

        while (true) {

            if (!change.isEmpty()) {
                // 변경하는 곳의 첫번째 값
                Point dir = change.peekFirst();
                if (sec == dir.x) { // 현재 시각과 변경 시각이 같다면
                    if (dir.y == 1) {   // 오른쪽으로 바뀔 때,
                        d = (d + 1) % 4;
                    } else {    // 왼쪽으로 바뀔 때, 방향 전환
                        d = (d + 3) % 4;
                    }
                    change.pollFirst(); // 이미 바꿔줬으니 큐에서 뺌
                }
            }

            Point p = snake.peekFirst();    // 뱀의 머리
            int nx = p.x + delta[d][0];
            int ny = p.y + delta[d][1];
            Point temp = new Point(nx, ny); // 다음 뱀의 위치

            if (nx <= 0 || ny <= 0 || nx > N || ny > N)
                return; // 만약 벽에 부딪히면 종료
            if (board[nx][ny] == 9)
                return; // 뱀의 몸통과 부딪히면 종료

            if (board[nx][ny] == 1) {   // 사과가 있다면
                board[nx][ny] = 9;  // 다음 위치에 뱀 존재 = 9
                snake.addFirst(temp);   // 머리 위치 (가장 앞)에 다음 위치 저장
            } else {    // 사과가 없다면
                board[nx][ny] = 9;  // 다음 위치에 뱀 존재 = 9
                snake.addFirst(temp);   // 다음 위치에 뱀 머리
                Point point = snake.pollLast(); // 뱀 꼬리는 이동해서 사라짐
                board[point.x][point.y] = 0;    // 뱀 꼬리 위치는 뱀이 없으니 0으로 바꿈
            }

            sec++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        snake = new ArrayDeque<>(); // 뱀의 몸통: peekFirst = 머리, peekLast = 꼬리
        change = new ArrayDeque<>();    // 방향을 바꾸는 경우 x: 초, y: 방향

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            // 사과가 있는 곳의 값을 1로 변경
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());

        sec = 0;

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int D = 0;  // 왼쪽으로 이동 시 방향 0

            // D, 즉 오른쪽으로 이동 시, 방향값을 1로 준다.
            if (st.nextToken().equals("D")) {
                D = 1;
            }

            change.add(new Point(X, D));
        }

        snake.add(new Point(1, 1)); // 시작과 동시에 (1, 1)에 뱀 존재
        board[1][1] = 9;    // 첫번째에는 뱀이 존재하기 때문에 9로 변경
        move();

        System.out.println(sec + 1);    // 시작할 때 1초기 때문에 마지막에 +1
    }
}
