package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁_전투 {
    static int [] dx = {-1,0,0,1};
    static int [] dy = {0,-1,1,0};
    static boolean [][] visited;
    static char[][] field;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        field = new char[M][N];
        visited = new boolean[M][N];
        for(int i = 0 ; i < M ; i ++){
            field[i] = br.readLine().toCharArray();
        }

        int power_b = 0;
        int power_w = 0;
        for(int i = 0 ; i < M ; i ++){
            for(int j = 0 ; j < N ; j ++){
                if (visited[i][j] == false){
                    int [] tmp = bfs(i,j);
                    power_w += Math.pow(tmp[0],2);
                    power_b += Math.pow(tmp[1],2);
                }
            }
        }
        System.out.println(power_w+" "+power_b);


    }



    static int[] bfs(int x,int y) {
        int cnt = 0;
        char color = field[x][y];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{x, y});
        cnt += 1;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                if (!visited[nx][ny] && field[nx][ny] == color) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return color == 'W' ? new int[]{cnt, 0} : new int[]{0, cnt};
    }
}
