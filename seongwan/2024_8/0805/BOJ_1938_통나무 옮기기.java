import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    //위 이동 - 맨 위쪽 확인
    //아래 이동 - 맨 아래 확인
    //오른쪽 이동 - 맨 오른쪽 확인
    //왼쪽 이동 - 왼쪽 확인
    //세로 -> 가로 - 좌,우 다 확인
    //가로-> 세로 - 위,아래 다 확인
    //가장 왼쪽, 위에 있는 통나무 좌표를 기준으로 세로,가로 여부와 함께 방문 처리
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;
    static boolean[][][] visit;
    static int[] start = new int[3];//r,c,세로 여부 - 가로0,세로1
    static int[] end = new int[3];//r,c,세로 여부 - 가로0,세로1

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visit = new boolean[N][N][2];//통나무 맨 왼,위 값과 가로,세로 여부에 따라 방문처리

        boolean started = false;
        boolean ended = false;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //통나무 시작점 찾기
                if (map[i][j] == 'B' && !started) {
                    started = true;
                    start[0] = i;
                    start[1] = j;

                    //세로인 경우
                    if (inRange(i + 1, j) && map[i + 1][j] == 'B') {
                        start[2] = 1;
                    }
                }

                //통나무 도착점 찾기
                if (map[i][j] == 'E' && !ended) {
                    ended = true;
                    end[0] = i;
                    end[1] = j;

                    //세로인 경우
                    if (inRange(i + 1, j) && map[i + 1][j] == 'E') {
                        end[2] = 1;
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        int ans = 1;
        queue.add(start);
        visit[start[0]][start[1]][start[2]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int cr = now[0];
                int cc = now[1];
                int vert = now[2];

                //세로인 경우
                if (vert == 1) {
                    //위로 이동
                    int nr = now[0] - 1;
                    if (inRange(nr, cc) && map[nr][cc] != '1' && !visit[nr][cc][vert]) {
                        if (end[0] == nr && end[1] == cc && end[2] == vert) {
                            return ans;
                        }
                        visit[nr][cc][vert] = true;
                        queue.add(new int[]{nr, cc, vert});
                    }
                    //아래로 이동
                    nr = now[0] + 1;
                    if (inRange(nr + 2, cc) && map[nr + 2][cc] != '1' && !visit[nr][cc][vert]) {
                        if (end[0] == nr && end[1] == cc && end[2] == vert) {
                            return ans;
                        }
                        visit[nr][cc][vert] = true;
                        queue.add(new int[]{nr, cc, vert});
                    }
                    //좌로 이동
                    int nc = now[1] - 1;
                    if (inRange(cr, nc) && !visit[cr][nc][vert] && map[cr][nc] != '1' && map[cr + 1][nc] != '1' && map[cr + 2][nc] != '1') {
                        if (end[0] == cr && end[1] == nc && end[2] == vert) {
                            return ans;
                        }
                        visit[cr][nc][vert] = true;
                        queue.add(new int[]{cr, nc, vert});
                    }
                    //우로 이동
                    nc = now[1] + 1;
                    if (inRange(cr, nc) && !visit[cr][nc][vert] && map[cr][nc] != '1' && map[cr + 1][nc] != '1' && map[cr + 2][nc] != '1') {
                        if (end[0] == cr && end[1] == nc && end[2] == vert) {
                            return ans;
                        }
                        visit[cr][nc][vert] = true;
                        queue.add(new int[]{cr, nc, vert});
                    }
                    //세로->가로 회전
                    nr = cr + 1;
                    nc = cc - 1;
                    if (inRange(nr, nc) && inRange(nr, nc + 2) && !visit[nr][nc][0] && map[cr][cc - 1] != '1' && map[cr + 1][cc - 1] != '1' && map[cr + 2][cc - 1] != '1'
                            && map[cr][cc + 1] != '1' && map[cr + 1][cc + 1] != '1' && map[cr + 2][cc + 1] != '1') {
                        if (end[0] == nr && end[1] == nc && end[2] == 0) {
                            return ans;
                        }
                        visit[nr][nc][0] = true;
                        queue.add(new int[]{nr, nc, 0});
                    }
                }

                //가로인 경우
                if (vert == 0) {
                    //위로 이동
                    int nr = now[0] - 1;
                    if (inRange(nr, cc) && !visit[nr][cc][vert] && map[nr][cc] != '1' && map[nr][cc + 1] != '1' && map[nr][cc + 2] != '1') {
                        if (end[0] == nr && end[1] == cc && end[2] == vert) {
                            return ans;
                        }
                        visit[nr][cc][vert] = true;
                        queue.add(new int[]{nr, cc, vert});
                    }
                    //아래로 이동
                    nr = now[0] + 1;
                    if (inRange(nr, cc) && !visit[nr][cc][vert] && map[nr][cc] != '1' && map[nr][cc + 1] != '1' && map[nr][cc + 2] != '1') {
                        if (end[0] == nr && end[1] == cc && end[2] == vert) {
                            return ans;
                        }
                        visit[nr][cc][vert] = true;
                        queue.add(new int[]{nr, cc, vert});
                    }
                    //좌로 이동
                    int nc = now[1] - 1;
                    if (inRange(cr, nc) && map[cr][nc] != '1' && !visit[cr][nc][vert]) {
                        if (end[0] == cr && end[1] == nc && end[2] == vert) {
                            return ans;
                        }
                        visit[cr][nc][vert] = true;
                        queue.add(new int[]{cr, nc, vert});
                    }
                    //우로 이동
                    nc = now[1] + 1;
                    if (inRange(cr, nc + 2) && map[cr][nc + 2] != '1' && !visit[cr][nc][vert]) {
                        if (end[0] == cr && end[1] == nc && end[2] == vert) {
                            return ans;
                        }
                        visit[cr][nc][vert] = true;
                        queue.add(new int[]{cr, nc, vert});
                    }
                    //가로->세로 회전
                    nr = cr - 1;
                    nc = cc + 1;
                    if (inRange(nr, nc) && inRange(nr + 2, nc) && !visit[nr][nc][1] && map[cr - 1][cc] != '1' && map[cr - 1][cc + 1] != '1' && map[cr - 1][cc + 2] != '1'
                            && map[cr + 1][cc] != '1' && map[cr + 1][cc + 1] != '1' && map[cr + 1][cc + 2] != '1') {
                        if (end[0] == nr && end[1] == nc && end[2] == 1) {
                            return ans;
                        }
                        visit[nr][nc][1] = true;
                        queue.add(new int[]{nr, nc, 1});
                    }
                }
            }
            ans++;
        }
        return 0;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
