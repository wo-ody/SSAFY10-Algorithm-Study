import java.io.*;
import java.util.*;

public class Main {
    private static int K, W, H, result;
    private static int[][] map;
    private static boolean[][][] isVisited;
    private static Queue<Point> q;
    private static int[][] horse = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 },
            { 2, 1 } };
    private static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private static void bfs(int x, int y) {

        q.add(new Point(x, y, 0, 0));
        isVisited[x][y][0] = true;

        while (!q.isEmpty()) {

            Point now = q.poll();

            if (now.x == H - 1 && now.y == W - 1) {
                result = Math.min(result, now.move);
                continue;
            }

            if (now.count < K) {
                for (int[] d : horse) {
                    int nx = now.x + d[0];
                    int ny = now.y + d[1];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1)
                        continue;

                    if (!isVisited[nx][ny][now.count+1]) {
                        isVisited[nx][ny][now.count+1] = true;
                        q.add(new Point(nx, ny, now.count + 1, now.move + 1));
                    }
                }
            }

            for (int[] d : delta) {
                int nx = now.x + d[0];
                int ny = now.y + d[1];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1)
                    continue;

                if (!isVisited[nx][ny][now.count]) {
                    isVisited[nx][ny][now.count] = true;
                    q.add(new Point(nx, ny, now.count, now.move + 1));
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        q = new ArrayDeque<>();
        isVisited = new boolean[H][W][K+1];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);

    }

    static class Point {
        int x, y;
        int count, move;

        public Point(int x, int y, int count, int move) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.move = move;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "] [" + count + ", " + move + "]";
        }

    }
}
