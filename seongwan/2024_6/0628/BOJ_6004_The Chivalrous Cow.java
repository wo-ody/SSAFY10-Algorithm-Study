import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] cow = new int[2];
    static int[] end = new int[2];
    static int R, C;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dc = {-1, 1, -1, 1, -2, 2, -2, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'K') {
                    cow[0] = i;
                    cow[1] = j;
                }

                if (map[i][j] == 'H') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(cow);
        visit[cow[0]][cow[1]] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int cr = temp[0];
                int cc = temp[1];

                for (int dir = 0; dir < 8; dir++) {
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];

                    if (cango(nr, nc)) {
                        if (map[nr][nc] == 'H') {
                            return time;
                        }
                        queue.add(new int[]{nr, nc});
                        visit[nr][nc] = true;
                    }
                }
            }
        }
        return time;
    }

    static boolean cango(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C && !visit[r][c] && map[r][c] != '*';
    }
}