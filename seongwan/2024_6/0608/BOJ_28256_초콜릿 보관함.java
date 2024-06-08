import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int T;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visit;
    static List<Integer> result = new ArrayList<>();
    static char[][] map = new char[3][3];

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            for (int i = 0; i < 3; i++) {
                map[i] = br.readLine().toCharArray();
            }

            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] input = new int[count];
            result.clear();

            for (int i = 0; i < count; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == 'O' && !visit[i][j])
                        result.add(bfs(i, j));
                }
            }
            Collections.sort(result);

            boolean check = true;
            if (result.size() == count) {
                for (int i = 0; i < count; i++) {
                    if (result.get(i) != input[i]) {
                        sb.append(0).append("\n");
                        check = false;
                        break;
                    }
                }
                if (check)
                    sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int bfs(int r, int c) {
        Deque<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        queue.add(new int[]{r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cr = temp[0];
            int cc = temp[1];
            cnt++;

            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if (cango(nr, nc)) {
                    visit[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return cnt;
    }

    static boolean cango(int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3 && !visit[r][c] && map[r][c] == 'O';
    }
}