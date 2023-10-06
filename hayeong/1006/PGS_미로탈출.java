import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PGS_미로탈출 {
    static char[][] board; // 입력 문자열을 문자로 바꾼 배열
    static int[][] visited; // 방문체크
    static int N, M; // 행, 열 길이

    // delta
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // public static void main(String[] args) {
    //     String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
    //     System.out.println(solution(maps)); //16
    //     maps = new String[]{"SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE"};
    //     System.out.println(solution(maps)); //8
    // }

    public static int solution(String[] maps) {
        int answer = 0;
        N = maps.length; // 행 길이
        M = maps[0].length(); // 열 길이

        // 방문배열 초기화
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        // 시작, 끝, 레버 위치 찾기 및 입력 배열 처리
        Point start = null;
        Point end = null;
        Point lever = null;

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                board[i][j] = c;
                if (c == 'S') {
                    start = new Point(i, j);
                } else if (c == 'E') {
                    end = new Point(i, j);
                } else if (c == 'L') {
                    lever = new Point(i, j);
                }
            }
        }

        // 시작부터 레버 위치까지 걸리는 시간
        int toLever = bfs(start, lever);

        if (toLever == -1) answer = -1; // 레버까지 못가면 -1 반환
        else { // 레버까지 갔다면
            answer += toLever; // 걸린 시간에 추가

            // 방문배열 초기화
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], -1);
            }

            // 레버에서 출구까지 걸리는 시간
            int toEnd = bfs(lever, end);

            if(toEnd == -1) // 레버까지는 갔지만 출구까지는 못 간 경우
                answer = -1;

            else answer += toEnd; // 레버까지도 가고 출구까지도 간 경우(탈출 가능한 경우)
        }

        return answer;
    }

    static int bfs(Point s, Point l) {
        Queue<Point> q = new ArrayDeque<>();
        visited[s.x][s.y] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == l.x && cur.y == l.y) break;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (canGo(nx, ny)) {
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
        }
        return visited[l.x][l.y];
    }

    static boolean canGo(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false; // 범위 밖
        if (visited[x][y] != -1) return false; // 방문한 적 O
        if (board[x][y] == 'X') return false; // 벽
        return true;
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
