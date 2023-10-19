import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2146_다리만들기 {
    static int N;
    static int[][] init;

    static int[][] board;
    static boolean[][] visit;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static ArrayList<Integer> edgeX = new ArrayList<>();
    static ArrayList<Integer> edgeY = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        init = new int[N][N];
        board = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 구분하기
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (init[i][j] != 0 && !visit[i][j]) {
                    BFS(i, j, cnt);
                    cnt++;
                }
            }
        }

        // 섬 간 최단거리
        // 각 셀에서 BFS를 돌린다
        // 바다만 큐에 들어간다.
        // 현재 섬과 같은 섬은 큐에서 제외한다.
        // 다른 섬을 만나면 리턴한다.
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue; // 바다면 컨티뉴

                // 섬이면 최단거리 구하기
                int dist = pathBFS(i, j, board[i][j]);

                // 만약 다른 섬이랑 연결 못한 경우, 컨티뉴
                if (dist == -1) continue;

                // 다른 섬이랑 만났다면 최솟값 갱신
                ans = dist < ans ? dist : ans;

            }
        }
        System.out.println(ans);
    }

    // 최단거리 찾기
    static int pathBFS(int x, int y, int curIsland) {
        Queue<Integer> q = new ArrayDeque<>();
        int[][] pathVisit = new int[N][N];
        q.add(x);
        q.add(y);
        pathVisit[x][y] = 1; // 마지막 답에서 -1 해주기 잊지 말자!

        while (!q.isEmpty()) {
            int curX = q.poll();
            int curY = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                // 범위 밖이면 컨티뉴
                if (!inRange(nx, ny)) continue;

                // 0보다 클때 (섬일때), 다른 섬을 만나면 결과 리턴
                if (board[nx][ny] > 0 && board[nx][ny] != curIsland) {
                    return pathVisit[curX][curY] - 1;
                }

                // 0일때(바다) -> BFS계속 돌기
                else if (board[nx][ny] == 0) {
                    if (pathVisit[nx][ny] == 0) {
                        q.add(nx);
                        q.add(ny);
                        pathVisit[nx][ny] = pathVisit[curX][curY] + 1;
                    }
                }
            }
        }
        return -1;
    }


    // for 섬 라벨링
    static void BFS(int x, int y, int cnt) {
        Queue<Integer> q = new ArrayDeque<>();
        visit[x][y] = true;
        board[x][y] = cnt;
        q.add(x);
        q.add(y);

        while (!q.isEmpty()) {
            int curX = q.poll();
            int curY = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if (canGo(nx, ny)) {
                    visit[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    board[nx][ny] = cnt;
                }
            }

        }

    }

    static boolean canGo(int x, int y) {
        // 범위 밖일때
        if (!inRange(x, y)) return false;
        // 바다일때
        if (init[x][y] == 0) return false;
        // 이미 방문했을때
        if (visit[x][y]) return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
