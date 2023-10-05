package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
    static StringTokenizer st;
    static int[][] map;
    static int n; // 세로 크기
    static int m; // 가로 크기
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] copyMap;
    static int count;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
            }
        }
        dfs(0);
        System.out.println(max);

    }

    static void dfs(int wall) {
        if (wall == 3) {
            virus();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void virus() {
        Queue<int[]> queue = new LinkedList<>();
        copyMap = new int[n][m];
        count = 0;
        // 복사본 맵 생성해서 값 넣어주고
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 그 중에 바이러스인 좌표 큐에 넣었으니깐 상하좌우로 0인 좌표들 큐에 넣고 감염시키기
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && (copyMap[nx][ny] == 0)) {
                	copyMap[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        // 감염 다 시켰으면 안전영역 개수 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);



    }
}
