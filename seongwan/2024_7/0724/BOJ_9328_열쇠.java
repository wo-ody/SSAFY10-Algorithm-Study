import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, h, w, ans;
    static char[][] map;
    static List<int[]> start;
    static boolean[] keys;
    static Deque<int[]> queue = new ArrayDeque<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            start = new ArrayList<>();
            keys = new boolean[26];
            ans = 0;

            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);

                    //가장자리에 있는 경우
                    if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        if (map[i][j] == '*')
                            continue;

                        if (map[i][j] == '$') {
                            ans++;
                            map[i][j] = '.';
                        }

                        if (isKey(i, j)) {
                            keys[map[i][j] - 'a'] = true;
                            map[i][j] = '.';
                        }

                        start.add(new int[]{i, j});
                    }
                }
            }

            String key = br.readLine();
            if (!key.equals("0")) {
                int keySize = key.length();
                for (int i = 0; i < keySize; i++) {
                    keys[key.charAt(i) - 'a'] = true;
                }
            }

            bfs();

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        boolean[][] visit = new boolean[h][w];
        boolean check = false;
        for (int[] start : start) {
            int cr = start[0];
            int cc = start[1];

            if (isDoor(cr, cc)) {
                if (keys[map[cr][cc] - 'A']) {
                    map[cr][cc] = '.';
                } else continue;
            }

            visit[start[0]][start[1]] = true;
            queue.add(start);
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cr = temp[0];
            int cc = temp[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if (!canGo(nr, nc) || visit[nr][nc] || map[nr][nc] == '*')
                    continue;

                if (map[nr][nc] == '$') {
                    ans++;
                    map[nr][nc] = '.';

                }

                if (isKey(nr, nc)) {
                    int keyNum = map[nr][nc] - 'a';
                    if (keys[keyNum]) {
                        map[nr][nc] = '.';
                    } else {
                        keys[map[nr][nc] - 'a'] = true;
                        check = true;
                    }
                }

                if (isDoor(nr, nc)) {
                    int doorNum = map[nr][nc] - 'A';

                    if (keys[doorNum]) {
                        map[nr][nc] = '.';
                    } else continue;
                }

                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }

        if (check)
            bfs();
    }

    static boolean isKey(int r, int c) {
        return map[r][c] - 'a' >= 0 && map[r][c] - 'a' <= 25;
    }

    static boolean isDoor(int r, int c) {
        return map[r][c] - 'A' >= 0 && map[r][c] - 'A' <= 25;
    }

    static boolean canGo(int r, int c) {
        return r >= 0 && r <= h - 1 && c >= 0 && c <= w - 1;
    }
}