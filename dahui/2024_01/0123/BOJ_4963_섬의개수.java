import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
    static boolean[][] visit;
    static int[][] map;
    static int w,h;
    static int[] dx = {-1,1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{


        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            //입력 받기
            init();

            count();
        }

        System.out.println(sb);
    }
    public static void init() throws IOException {
        visit = new boolean[h][w];
        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void count() {
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //방문하지 않은 섬이고 육지라면
                if(!visit[i][j] && map[i][j] == 1) {
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        sb.append(cnt).append("\n");
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        visit[y][x] = true;

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int py = arr[0];
            int px = arr[1];

            for (int d = 0; d < 8; d++) {
                int ny = py;
                int nx = px;

                while(true) {
                    nx += dx[d];
                    ny += dy[d];

                    if(nx < 0 || nx >= w || ny < 0 || ny >= h ||
                            visit[ny][nx] || map[ny][nx] == 0) break;

                    visit[ny][nx] = true;
                    q.add(new int[] {ny,nx});
                }
            }
        }
    }
}
