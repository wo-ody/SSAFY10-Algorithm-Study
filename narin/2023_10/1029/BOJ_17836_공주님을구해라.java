import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, T, result;
    private static int[][] castle;
    private static boolean[][] isVisited;
    private static int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }

    }

    private static void bfs(int x, int y) {
        int count=0;
        Queue<Point> q = new ArrayDeque<>();

        q.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Point p = q.poll();

                if(castle[p.x][p.y] == 2){
                    result = count+N-1-p.x+M-1-p.y;
                    continue;
                } else if(p.x == N-1 && p.y == M-1){
                    result = Math.min(result, count);
                    return;
                }

                for (int[] d : delta) {
                    int nx = p.x + d[0];
                    int ny = p.y + d[1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || isVisited[nx][ny])
                        continue;
                    if (castle[nx][ny] == 1)
                        continue;

                    isVisited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
            count++;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        castle = new int[N][M];
        isVisited = new boolean[N][M];
        result = 10001;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 0 빈공간, 1 마법의 벽, 2는 그람의 위치
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        if (result > T ) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }
}
