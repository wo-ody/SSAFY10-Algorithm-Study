import java.io.*;
import java.util.*;

public class Main {

    private static int I, sx, sy, ex, ey, result;
    private static boolean[][] isVisited;
    private static int[][] delta = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
            { -1, -2 } };

    private static void bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        isVisited[x][y] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                Point p = q.poll();

                if(p.x == ex && p.y==ey) return;

                for(int[] d : delta){
                    int nx = p.x + d[0];
                    int ny = p.y + d[1];

                    if(nx<0||ny<0||nx>=I||ny>=I) continue;
                    if(isVisited[nx][ny]) continue;

                    isVisited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
            result++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            I = Integer.parseInt(br.readLine());
            isVisited = new boolean[I][I];
            result = 0;

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            isVisited[sx][sy] = true;

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs(sx, sy);

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }

    static class Point{
        int x, y;

        public Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
}
